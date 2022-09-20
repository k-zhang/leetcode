package com.algomind.leetcode.medium;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            int j = i - 1;
            int max = 0;
            while ((i - j) <= k && j >= 0) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                j--;
            }
        }
        return dp[arr.length];
    }
}
