package com.algomind.leetcode.mincostclimbingstairs;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; dp[1] = cost[0];

        for(int i = 2; i <= cost.length ; i ++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-1]);
        }

        return Math.min(dp[cost.length], dp[cost.length-1]);
    }
}
