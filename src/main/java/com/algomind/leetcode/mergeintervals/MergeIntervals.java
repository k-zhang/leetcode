package com.algomind.leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1 ; i < intervals.length; i ++) {
            int[] interval = intervals[i];
            boolean consumed = false;
            for (int[] currentResult : result) {
                if (interval[0] >= currentResult[0] && interval[1] <= currentResult[1]) {
                    consumed = true;
                } else if (interval[0] <= currentResult[1] && interval[1] > currentResult[1]) {
                    currentResult[0] = currentResult[0];
                    currentResult[1] = interval[1];
                    consumed = true;
                } else {
                    consumed = false;
                }
            }

            if(!consumed) result.add(new int[]{interval[0], interval[1]});
        }

        return result.toArray(new int[0][0]);
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

        List<int[]> result = new ArrayList<>();

        for(int i = 0 ; i < intervals.length - 1; i ++) {
            int[] current = intervals[i];
            int[] next = intervals[i+1];

            if (next[0] >= current[0] && next[1] <= current[1]) {
                next[0] = current[0];
                next[1] = current[1];
            } else if (next[0] <= current[1] && next[1] > current[1]) {
                next[0] = current[0];
                next[1] = next[1];
            } else {
                result.add(new int[]{current[0], current[1]});
            }
        }

        result.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});

        return result.toArray(new int[0][0]);
    }
}
