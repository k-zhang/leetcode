package com.algomind.leetcode.threeequalparts;

public class ThreeEqualParts1 {
    public int[] threeEqualParts(int[] arr) {
        int sum[] = new int[arr.length];
        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++)
            sum[i] = sum[i-1] + arr[i];
        if(sum[arr.length - 1] == 0)
            return new int[]{0, arr.length - 1};
        int tot = sum[arr.length - 1];
        if(tot % 3 != 0)
            return new int[]{-1, -1};
        int lastZeroCnt = 0;
        while(arr[arr.length - 1 - lastZeroCnt] == 0)
            lastZeroCnt++;
        int pos1 = lowerBound(sum, 0, sum.length, tot / 3) + lastZeroCnt;
        int pos2 = lowerBound(sum, 0, sum.length, tot * 2 / 3) + lastZeroCnt + 1;
        int end1 = pos1, end2 = pos2 - 1, end3 = arr.length - 1;
        while(end1 >= 0 && end2 > pos1 && end3 >= pos2) {
            if(arr[end1] == arr[end2] && arr[end2] == arr[end3]){
                end1--;
                end2--;
                end3--;
            } else {
                return new int[]{-1, -1};
            }
        }

        if(end1>=0 && sum[end1] > 0) return new int[]{-1, -1};

        return new int[]{pos1, pos2};
    }

    private int lowerBound(int[] arr, int begin, int end, int tar) {
        while(begin < end) {
            int mid = begin + (end - begin) / 2;
            if(arr[mid] < tar)
                begin = mid + 1;
            else
                end = mid;
        }
        return begin;
    }
}
