package com.algomind.leetcode.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        if (n == 1 && m == 1) return List.of(matrix[0][0]);

        int ringCount = (int) Math.ceil(Math.min(n,m) / 2d);

        var result = new ArrayList<Integer>();

        for (int ring = 0; ring < ringCount; ring++) {
            for (int x = ring; x < n - ring; x++) result.add(matrix[ring][x]);
            for (int y = ring + 1; y < m - ring; y++) result.add(matrix[y][n - ring - 1]);
            if(m - ring - 1 != ring) for (int x = n - ring - 2; x >= ring; x--) result.add(matrix[m - ring - 1][x]);
            if(ring != n - ring - 1) for (int y = m - ring - 2; y >= ring + 1; y--) result.add(matrix[y][ring]);
        }

        return result;
    }
}
