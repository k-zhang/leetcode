package com.algomind.leetcode.minimumpathsum;

public class MinimumPathSum {
    // 2D DP
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];

        for(int y = 0 ; y < height ; y++) {
            for(int x = 0 ; x < width ; x++) {
                if(x == 0 && y == 0) continue;

                int top = y - 1 >= 0 ? dp[y-1][x] : Integer.MAX_VALUE;
                int left = x - 1 >= 0 ? dp[y][x-1] : Integer.MAX_VALUE;

                dp[y][x] = Math.min(top, left) + grid[y][x];
            }
        }

        return dp[height - 1][width - 1];
    }

    // 1D DP
    public int minPathSum1(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        int[] dp = new int[width];
        dp[0] = grid[0][0];

        for(int y = 0 ; y < height ; y++) {
            for(int x = 0 ; x < width ; x++) {
                if(x == 0 && y == 0) continue;

                int top = y != 0 ? dp[x] : Integer.MAX_VALUE;
                int left = x - 1 >= 0 ? dp[x-1] : Integer.MAX_VALUE;

                dp[x] = Math.min(top, left) + grid[y][x];
            }
        }

        return dp[width - 1];
    }
}
