package com.algomind.leetcode.medium;

import java.util.*;

public class CarPooling {
    // First accepted
    public boolean carPooling(int[][] trips, int capacity) {
        var getOnMap = new HashMap<Integer, Integer>();
        var getOffMap = new HashMap<Integer, Integer>();

        var locationSet = new TreeSet<Integer>();
        for(var trip : trips) {
            getOnMap.merge(trip[1], trip[0], (v1, v2) -> v1 + trip[0]);
            getOffMap.merge(trip[2], trip[0], (v1, v2) -> v1 + trip[0]);
            locationSet.add(trip[1]);
            locationSet.add(trip[2]);
        }

        int passengers = 0;
        for(var location : locationSet) {
            passengers -= getOffMap.getOrDefault(location, 0);
            passengers += getOnMap.getOrDefault(location, 0);
            if(passengers > capacity) return false;
        }

        return true;
    }

    // Simplified approach 1
    public boolean carPooling1(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<>();
        for (int[] trip : trips) {
            int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
            timestamp.put(trip[1], startPassenger);

            int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
            timestamp.put(trip[2], endPassenger);
        }

        int usedCapacity = 0;
        for (int passengerChange : timestamp.values()) {
            usedCapacity += passengerChange;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    // Fastest
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;
        for (int number : timestamp) {
            usedCapacity += number;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
