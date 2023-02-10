package com.algomind.leetcode.medium;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        final int MAX_DISTANCE = n + n + 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = MAX_DISTANCE;
                    grid[i][j] = Math.min(
                            grid[i][j],
                            Math.min(i > 0 ? grid[i - 1][j] + 1 : MAX_DISTANCE, j > 0 ? grid[i][j - 1] + 1 : MAX_DISTANCE)
                    );
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                grid[i][j] = Math.min(
                        grid[i][j],
                        Math.min(i < n - 1 ? grid[i + 1][j] + 1 : MAX_DISTANCE, j < n - 1 ? grid[i][j + 1] + 1 : MAX_DISTANCE));

                ans = Math.max(ans, grid[i][j]);
            }
        }

        return ans == 0 || ans == MAX_DISTANCE ? -1 : ans;
    }
}

