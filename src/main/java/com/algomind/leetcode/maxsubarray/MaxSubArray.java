package com.algomind.leetcode.maxsubarray;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];

        for(int i = 1 ; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i-1],0) + nums[i];
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
