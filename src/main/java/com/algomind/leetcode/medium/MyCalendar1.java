package com.algomind.leetcode.medium;

import java.util.TreeMap;

public class MyCalendar1 {
    TreeMap<Integer, Integer> calendar;

    MyCalendar1() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);

        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }

        return false;
    }
}