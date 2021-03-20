package com.algomind.leetcode.matrixblocksum;

// Dynamic Programming
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] mc = calculateSumMatrix(mat);

        int[][] result = new int[mat.length][mat[0].length];
        for(int y = 0 ; y < mat.length ; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                int xLeft = Math.max(x - K, 0);
                int xRight = Math.min(x + K, mat[0].length-1);
                int yTop = Math.max(y - K, 0);
                int yBottom = Math.min(y + K, mat.length-1);

                result[y][x] = mc[yBottom][xRight];
                if(yTop - 1 >= 0) result[y][x] -= mc[yTop-1][xRight];
                if(xLeft - 1 >= 0) result[y][x] -= mc[yBottom][xLeft - 1];
                if(yTop - 1 >= 0 && xLeft - 1 >= 0) result[y][x] += mc[yTop-1][xLeft - 1];
            }
        }

        return result;
    }

    public int[][] calculateSumMatrix(int[][] mat) {
        int[][] mc = new int[mat.length][mat[0].length];

        // Initialize first row and first column
        mc[0][0] = mat[0][0];
        for(int x = 1 ; x < mat[0].length ; x++) mc[0][x] = mc[0][x-1] + mat[0][x];
        for(int y = 1 ; y < mat.length ; y++) mc[y][0] = mc[y-1][0] + mat[y][0];

        for(int y = 1 ; y < mat.length ; y++) {
            for(int x = 1 ; x < mat[0].length ; x++) {
                mc[y][x] = mc[y][x-1] + mc[y-1][x] - mc[y-1][x-1] + mat[y][x];
            }
        }

        return mc;
    }
}
