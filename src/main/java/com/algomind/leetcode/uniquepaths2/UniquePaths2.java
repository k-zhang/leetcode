package com.algomind.leetcode.uniquepaths2;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;

        obstacleGrid[0][0] = 1;

        for(int y = 0; y < m; y++) {
            for(int x = 0 ; x < n ; x++) {
                if(x == 0 && y == 0) continue;

                if(obstacleGrid[y][x] == 1) {
                    obstacleGrid[y][x] = 0;
                    continue;
                }

                int top = y - 1 < 0 ? 0 : obstacleGrid[y-1][x];
                int left = x - 1 < 0 ? 0 : obstacleGrid[y][x-1];
                obstacleGrid[y][x] = top + left;
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}
