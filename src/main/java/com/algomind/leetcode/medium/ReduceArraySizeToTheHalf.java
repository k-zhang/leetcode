package com.algomind.leetcode.medium;

import java.util.*;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        var frequency = new HashMap<Integer, Integer>();
        for(var number : arr) {
            var mapped = frequency.computeIfPresent(number, (k, v) -> v + 1);
            if(mapped == null) frequency.put(number, 1);
        }

        var list = new ArrayList<>(frequency.values());
        list.sort(Comparator.reverseOrder());

        int halfSize = arr.length / 2;
        int remainSize = arr.length;
        int result = 0;
        for (Integer integer : list) {
            remainSize -= integer;
            result++;
            if (remainSize <= halfSize) break;
        }

        return result;
    }
}
