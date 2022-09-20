package com.algomind.leetcode.medium;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int ringCount = (int)Math.ceil(n / 2d);
        int number = 1;

        for (int ring = 0; ring < ringCount; ring++) {
            for (int x = ring; x < n - ring; x++) matrix[ring][x] = number++;
            for (int y = ring + 1; y < n - ring; y++) matrix[y][n - ring - 1] = number++;
            if(n - ring - 1 != ring) for (int x = n - ring - 2; x >= ring; x--) matrix[n - ring - 1][x] = number++;
            if(ring != n - ring - 1) for (int y = n - ring - 2; y >= ring + 1; y--) matrix[y][ring] = number++;
        }

        return matrix;
    }

    public int[][] generateMatrix1(int n) {
        int[][] result = new int[n][n];

        int cnt = 1;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int d = 0;
        int row = 0;
        int col = 0;

        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }

        return result;
    }
}
