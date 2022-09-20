package com.algomind.leetcode.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    // Heap
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if(n == 0) return startFuel >= target ? 0 : -1;

        int fuelTank = startFuel, location = 0, refill = 0;
        var pastStation = new PriorityQueue<Integer>(Collections.reverseOrder());

        int i = 0;
        while( i <= n) {
            int nextDistance = i == n ? target - stations[n-1][0]  : stations[i][0] - location;

            if(fuelTank >= nextDistance) {
                if(i == n) break;

                fuelTank -= stations[i][0] - location;
                location = stations[i][0];
                pastStation.add(stations[i][1]);
                i++;
            }else{
                if(pastStation.size() == 0) return -1;
                fuelTank += pastStation.poll();
                refill ++;
            }
        }

        return refill;
    }

    // DP
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];

        dp[0] = startFuel;

        for (int i = 0; i < n; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= n; ++i)
            if (dp[i] >= target) return i;
            
        return -1;
    }
}
