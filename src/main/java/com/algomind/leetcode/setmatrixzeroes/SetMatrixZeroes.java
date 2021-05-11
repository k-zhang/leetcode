package com.algomind.leetcode.setmatrixzeroes;

// O(1) Space Solution
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;

        boolean topRowZero = false, leftColumnZero = false;

        for(int y = 0 ; y < h ; y ++) {
            for(int x = 0 ; x < w ; x ++) {
                if(matrix[y][x] == 0) {
                    if(y == 0 && x == 0) {
                        topRowZero = true;
                        leftColumnZero = true;
                    }else if(x == 0){
                        leftColumnZero = true;
                        matrix[y][0] = 0;
                    }else if(y == 0){
                        topRowZero = true;
                        matrix[0][x] = 0;
                    }else {
                        matrix[y][0] = 0;
                        matrix[0][x] = 0;
                    }
                }
            }
        }

       for(int x = 1 ; x < w ; x ++) {
           if(matrix[0][x] == 0) {
               fillColumnWithZero(matrix, x, h);
           }
       }

       for(int y = 1 ; y < h ; y ++) {
           if(matrix[y][0] == 0) {
               fillRowWithZero(matrix, y, w);
           }
       }

       if(topRowZero) fillRowWithZero(matrix, 0, w);
       if(leftColumnZero) fillColumnWithZero(matrix, 0, h);
    }

    private void fillRowWithZero(int[][] matrix, int y, int w) {
      for(int x = 0 ; x < w ; x++) matrix[y][x] = 0;
    }

    private void fillColumnWithZero(int[][] matrix, int x, int h) {
        for(int y = 0 ; y < h ; y++) matrix[y][x] = 0;
    }
}
