package com.algomind.leetcode.matchstickstosquare;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makeSquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) sum += matchstick;
        if (sum== 0 || sum % 4 != 0) return false;
        int sideLength = sum / 4;

        Arrays.sort(matchsticks);
        return dfs(matchsticks,0, new int[4], sideLength);
    }

    private boolean dfs(int[] matchSticks, int index, int[] sums, int sideLength) {
        if(index == matchSticks.length) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        for(int i = 0 ; i < 4 ; i ++) {
            int matchstick = matchSticks[index];
            if(matchstick + sums[i] <= sideLength && (i == 0 || sums[i] != sums[i - 1])) {
                sums[i] += matchstick;
                if(dfs(matchSticks, index + 1, sums, sideLength)) return true;
                sums[i] -= matchstick;
            }
        }

        return false;
    }
}
