package com.algomind.leetcode.countsquaresubmatrices;

public class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        int result = 0;

        for(int y = 0 ; y < matrix.length ; y++) {
            for(int x = 0 ; x < matrix[0].length ; x++) {
                if(matrix[y][x] == 0) continue;
                if(x == 0 || y == 0) {
                    result++;
                    continue;
                }

                int min = Math.min(matrix[y-1][x-1], Math.min(matrix[y-1][x], matrix[y][x-1]));
                matrix[y][x] += min;
                result += matrix[y][x];
            }
        }

        return result;
    }
}
