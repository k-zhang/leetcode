package com.algomind.leetcode.easy;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        var result = new int[nums.length];
        int writePointer = 0;
        int xp = 0, yp = n;

        while(writePointer < nums.length) {
            result[writePointer++] = nums[xp++];
            result[writePointer++] = nums[yp++];
        }

        return result;
    }
}
