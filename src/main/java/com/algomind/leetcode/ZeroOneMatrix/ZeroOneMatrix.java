package com.algomind.leetcode.ZeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        var result = new int[n][m];
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                result[i][j] = -1;
            }
        }

        var queue = new LinkedList<int[]>();

        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                if(mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.addLast(new int[]{j, i});
                }
            }
        }

        var dir = new int[][]{{1,0}, {0,-1}, {-1, 0}, {0, 1}};
        while(!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            for(int[] d : dir) {
                int newX = Math.min(Math.max(0, current[0] + d[0]), m - 1);
                int newY = Math.min(Math.max(0, current[1] + d[1]), n - 1);
                int newD = result[current[1]][current[0]] + 1;
                if(result[newY][newX] == -1 || result[newY][newX] > newD) {
                    result[newY][newX] = newD;
                    queue.addLast(new int[]{newX, newY});
                }
            }
        }

        return result;
    }
}
