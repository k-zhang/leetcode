package com.algomind.leetcode.maxareaofapieceofcake;

import java.util.Arrays;

public class MaxAreaOfAPieceOfCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHori = getMaxOfDirection(h, horizontalCuts);
        long maxVert = getMaxOfDirection(w, verticalCuts);
        return (int)((maxHori * maxVert) % (1e9 + 7));
    }

    private long getMaxOfDirection(int len, int[] direction) {
        long max = len - direction[direction.length - 1];
        for(int i = direction.length - 1; i >= 0 ; i--) {
            int last = i != 0 ? direction[i - 1] : 0;
            max = Math.max(max, direction[i] - last);
        }
        return max;
    }
}
