package com.algomind.leetcode.rangeaddition;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        var result = new int[length];

        for(var update : updates) {
            for(int i = update[0] ; i <= update[1] ; i ++) {
                result[i] += update[2];
            }
        }

        return result;
    }

    public int[] getModifiedArray1(int length, int[][] updates) {
        var result = new int[length];

        for(var update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            result[start] += val;
            if(end + 1 < length) {
                result[end + 1] -= val;
            }
        }

        for(int i = 1 ; i < length ; i ++) {
            result[i] = result[i] + result[i - 1];
        }

        return result;
    }
}
