package com.algomind.leetcode.medium;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        if(time.length < 2) return 0;

        var multipleOf60 = multipleOf60();
        var map = new HashMap<Integer, Integer>();
        var result = 0;
        var maxInMap  = 0;
        for (int duration : time) {
            for (int multiple60 : multipleOf60) {
                if (duration > multiple60) continue;
                if (duration + maxInMap < multiple60) continue;

                var remainder = multiple60 - duration;
                if (map.containsKey(remainder)) result += map.get(remainder);
            }

            map.merge(duration, 1, Integer::sum);
            if (duration > maxInMap) maxInMap = duration;
        }

        return result;
    }

    private int[] multipleOf60() {
        var MAX_DURATION_DIVISIBLE = 960;
        var n = MAX_DURATION_DIVISIBLE / 60;
        var result = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            result[i] = 60 * (i + 1);
        }
        return result;
    }

    // if (a + b) % 60 = 0, then a and b must satisfy:
    // (a % 60 + b % 60) % 60 = 0
    // => b % 60 = 60 - a % 60
    // So if we have number a that a % 60 = 0, then all number b that satisfies b % 60 = 0 can be added with a so that (a + b) % 60 = 0
    // if we have a number a that a % 60 != 0, then all number b that hasa remainder equals to (60 - a % 60) can be added with a so that (a + b) % 60 = 0
    public int numPairsDivisibleBy60_1(int[] time) {
        var remainders = new int[60];
        var count = 0;
        for (var t: time) {
            if (t % 60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }
}
