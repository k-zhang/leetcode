package com.algomind.leetcode.burstballoons;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        int[][] dp = new int[n][n];

        for (int left = n - 2; left >= 1; left--) {
            for (int right = left; right <= n - 2; right++) {
                for (int i = left; i <= right; i++) {
                    int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                    int remaining = dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(remaining + gain, dp[left][right]);
                }
            }
        }
        return dp[1][n - 2];
    }
}
