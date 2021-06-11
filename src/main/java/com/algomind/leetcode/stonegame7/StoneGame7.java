package com.algomind.leetcode.stonegame7;

public class StoneGame7 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;

        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];

        for(int i = 0 ; i < n ; i ++) {
            for(int j = i ; j < n ; j ++) {
                if(i == j) sum[i][j] = stones[j];
                else sum[i][j] = sum[i][j - 1] + stones[j];
            }
        }

        for(int i = n - 1; i >= 0; i --) {
            for(int j = i + 1 ; j < n ; j ++) {
                dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j], sum[i][j - 1] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }
}
