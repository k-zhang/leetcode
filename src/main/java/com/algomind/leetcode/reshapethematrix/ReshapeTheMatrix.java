package com.algomind.leetcode.reshapethematrix;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        int total = m * n;
        if(r * c != total) return mat;

        int[][] result = new int[r][c];
        for(int y = 0 ; y < r ; y ++) {
            for(int x = 0 ; x < c ; x ++) {
                int index = y * c + x;
                int yy = index / m;
                int xx = index % m;

                result[y][x] = mat[yy][xx];
            }
        }

        return result;
    }
}
