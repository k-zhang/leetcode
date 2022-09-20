package com.algomind.leetcode.medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int y = 0 ; y < m ; y++) {
            for(int x = 0 ; x < n ; x++) {
                if(doSearch(board, x, y, word, 0, m, n))
                    return true;
            }
        }

        return false;
    }

    private boolean doSearch(char[][] board, int x, int y, String word, int index, int m, int n) {
        if(index == word.length()) return true;

        if(x < 0 || x >= n || y < 0 || y >= m || board[y][x] != word.charAt(index)) return false;

        board[y][x] = '#';

        int[] xOffset = {-1, 0, 1, 0};
        int[] yOffset = {0, 1, 0, -1};
        for(int i = 0 ; i < 4 ; i ++) {
            if(doSearch(board, x + xOffset[i], y + yOffset[i], word, index + 1, m, n)) return true;
        }

        board[y][x] = word.charAt(index);
        return false;
    }
}
