package com.algomind.leetcode.outofboundarypaths;

public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = 1000000007;
        int[][] dp = new int[m][n];
        int[][] dp1 = new int[m][n];
        dp[startRow][startColumn] = 1;

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        long result = 0;
        for(int i = 0 ; i < maxMove ; i ++) {
            for(int y = 0 ; y < m ; y++) {
                for(int x = 0 ; x < n ; x++) {
                    if(dp[y][x] != 0) {
                        for (int k = 0; k < 4; k++) {
                            int newX = x + directions[k][0];
                            int newY = y + directions[k][1];

                            if (newX == -1 || newY == -1 || newX == n || newY == m) result += dp[y][x];
                            else {
                                dp1[newY][newX] += dp[y][x];
                                dp1[newY][newX] %= MOD;
                            }
                        }
                        dp[y][x] = 0;
                    }
                }
            }

            int[][] temp = dp;
            dp = dp1;
            dp1 = temp;
        }

        return (int)(result % MOD);
    }
}
