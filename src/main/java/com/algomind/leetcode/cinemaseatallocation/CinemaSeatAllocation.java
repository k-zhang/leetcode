package com.algomind.leetcode.cinemaseatallocation;

import java.util.*;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int leftEmpty = 0b00001111;
        int middleEmpty = 0b11000011;
        int rightEmpty = 0b11110000;

        var reservedSeatMap = new HashMap<Integer, Integer>();
        for (int[] reserved : reservedSeats) {
            if (reserved[1] == 1 || reserved[1] == 10) continue;
            int currentReserved = reservedSeatMap.getOrDefault(reserved[0], 0);
            reservedSeatMap.put(reserved[0], currentReserved | (1 << (reserved[1] - 2)));
        }

        int result = (n - reservedSeatMap.size()) * 2;
        for(var row : reservedSeatMap.entrySet()) {
            var rowMap = row.getValue();
            if(((rowMap | leftEmpty) == leftEmpty) ||
               ((rowMap | middleEmpty) == middleEmpty) ||
               ((rowMap | rightEmpty) == rightEmpty))
                result++;
        }

        return result;
    }
}
