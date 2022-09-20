package com.algomind.leetcode.easy;

// Dynamic Programming
public class RangeSumQuery {
    private final int[] accSum;

    public RangeSumQuery(int[] nums) {
        accSum = new int[nums.length];
        accSum[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++) {
            accSum[i] = accSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return accSum[right] - (left == 0 ? 0 : accSum[left-1]);
    }
}
