package com.algomind.leetcode.medium;

import java.util.*;

public class InsertInterval {
    // Best answer
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(int[][]::new);
    }

    // My first answer
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        if(newInterval[1] < intervals[0][0]) {
            LinkedList<int[]> result = new LinkedList<>(Arrays.asList(intervals));
            result.addFirst(newInterval);
            return result.toArray(new int[0][0]);
        }

        int a = newInterval[0];
        int b = newInterval[1];

        int leftIndex = -1, rightIndex = -1;
        int leftNumber = -1, rightNumber = -1;

        // Find the index of the left interval to be replaced
        for(int i = 0 ; i < intervals.length ; i ++) {
            if(a <= intervals[i][1]) {
                leftIndex = i;
                if(a < intervals[i][0] ) {
                    leftNumber = a;
                }
                break;
            }
        }

        // No index is found, the new interval must be the last one to insert
        if(leftIndex == -1) {
            LinkedList<int[]> result = new LinkedList<>(Arrays.asList(intervals));
            result.addLast(newInterval);
            return result.toArray(new int[0][0]);
        }

        // Find the index of the right interval to be replaced
        for(int i = leftIndex ; i < intervals.length ; i ++) {
            if(b <= intervals[i][1]) {
                rightIndex = i;
                if(b < intervals[i][0] ) {
                    rightNumber = b;
                }
                break;
            }
        }

        // Copy the intervals up to the leftIndex
        List<int[]> result = new ArrayList<>();
        for(int i = 0 ; i < leftIndex ; i ++) result.add(intervals[i]);

        // Decide what to do for the intervals between leftIndex and rightIndex
        if(rightIndex == -1) {
            int newA = leftNumber == -1 ? intervals[leftIndex][0] : leftNumber;
            result.add(new int[]{newA, b});
        }else{
            int newA = leftNumber == -1 ? intervals[leftIndex][0] : leftNumber;
            int newB = rightNumber == -1 ? intervals[rightIndex][1] : rightNumber;
            result.add(new int[]{newA, newB});
        }

        // Copy the intervals in the right of rightIndex, if any
        if(rightIndex != -1) for(int i = rightNumber == -1 ? rightIndex + 1 : rightIndex; i < intervals.length; i++) result.add(intervals[i]);

        return result.toArray(new int[0][0]);
    }
}
