package com.algomind.leetcode.threeequalparts;

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        var sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i ++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        if(sum[arr.length - 1] == 0) {
            return new int[]{0, arr.length - 1};
        }

        int total = sum[arr.length - 1];
        if(total % 3 != 0) return new int[]{-1, -1};

        int tailZeroCount = 0 ;
        while(arr[arr.length - 1 - tailZeroCount] == 0) tailZeroCount ++;

        int i = search(sum, 0, sum.length, total / 3) + tailZeroCount;
        int j = search(sum, 0, sum.length, total * 2/ 3) + tailZeroCount + 1;

        int end1 = i, end2 = j - 1, end3 = arr.length - 1;
        while(end1 >= 0 && end2 > i && end3 >= j) {
            if(arr[end1] == arr[end2] && arr[end3] == arr[end2]) {
                end1 --;
                end2 --;
                end3 --;
            }else{
                return new int[]{-1, -1};
            }
        }

        if(end1>=0 && sum[end1] > 0) return new int[]{-1, -1};

        return new int[]{i,j};
    }

    private int search(int[] sum, int left, int right, int target) {
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(sum[mid] < target) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}
