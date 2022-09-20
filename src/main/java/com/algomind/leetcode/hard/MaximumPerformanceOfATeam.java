package com.algomind.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }

        Arrays.sort(items, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0, sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(queue.size() > k - 1){
                sum -= queue.poll();
            }
            res = Math.max(res, (sum + items[i][0])* items[i][1]);
            queue.add(items[i][0]);
            sum += items[i][0];
        }
        return (int)(res % ((int)1e9 + 7));
    }
}
