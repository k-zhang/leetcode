package com.algomind.leetcode.uniquepaths;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int y = 0; y < m; y++) {
            for(int x = 0 ; x < n ; x++) {
                if(x == 0 && y == 0) continue;
                int top = y - 1 < 0 ? 0 : dp[y-1][x];
                int left = x - 1 < 0 ? 0 : dp[y][x-1];
                dp[y][x] = top + left;
            }
        }

        return dp[m-1][n-1];
    }
}
