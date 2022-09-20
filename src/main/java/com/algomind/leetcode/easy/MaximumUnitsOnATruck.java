package com.algomind.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        var boxes = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        boxes.addAll(Arrays.asList(boxTypes));

        var result = 0;
        for(var i = 0 ; i < truckSize; i ++) {
            var top = boxes.peek();
            if(top == null) return result;

            if(top[0] > 1) {
                top[0] --;
            }else{
                top = boxes.poll();
            }

            result += top[1];
        }

        return result;
    }
}
