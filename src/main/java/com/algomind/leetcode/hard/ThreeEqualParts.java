package com.algomind.leetcode.hard;

import java.util.Arrays;

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

    public int[] threeEqualParts1(int[] arr) {
        int[] IMP = new int[]{-1, -1};
        int N = arr.length;

        int S = 0;
        for (int x: arr) S += x;
        if (S % 3 != 0) return IMP;
        int T = S / 3;
        if (T == 0)
            return new int[]{0, N - 1};

        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int su = 0;
        for (int i = 0; i < N; ++i) {
            if (arr[i] == 1) {
                su += 1;
                if (su == 1) i1 = i;
                if (su == T) j1 = i;
                if (su == T+1) i2 = i;
                if (su == 2*T) j2 = i;
                if (su == 2*T + 1) i3 = i;
                if (su == 3*T) j3 = i;
            }
        }

        // The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
        // where [i1, j1] is a block of 1s, etc.
        int[] part1 = Arrays.copyOfRange(arr, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return IMP;
        if (!Arrays.equals(part1, part3)) return IMP;

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = arr.length - j3 - 1;

        if (x < z || y < z) return IMP;
        return new int[]{j1+z, j2+z+1};
    }
}
