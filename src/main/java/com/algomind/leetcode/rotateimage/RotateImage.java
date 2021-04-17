package com.algomind.leetcode.rotateimage;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return;

        int ringCount = (int)Math.ceil(n / 2d);

        for(int ring = 0 ; ring < ringCount ; ring++) {
            for(int i = ring ; i < n - ring - 1; i++) {
                int temp = matrix[ring][i];
                temp = exchange(matrix, temp, n - 1 - ring, i);
                temp = exchange(matrix, temp, n - 1 - i, n - 1 - ring);
                temp = exchange(matrix, temp, ring, n - 1 - i);
                matrix[ring][i] = temp;
            }
        }
    }

    private int exchange(int[][] matrix, int number, int x, int y) {
        int oldNumber = matrix[y][x];
        matrix[y][x] = number;
        return oldNumber;
    }
}
