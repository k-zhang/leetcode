package com.algomind.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementStrStr {
    // Slow but accepted solution
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;

        int lenHayStack = haystack.length();
        int lenNeedle = needle.length();

        if(lenNeedle > lenHayStack) return -1;

        int i = 0, j = 0, start = -1;
        int nextStart = -1;
        char needleFirstChar = needle.charAt(0);

        while (i < lenHayStack) {
            if(nextStart == -1 && j != 0 && haystack.charAt(i) == needleFirstChar) {
                nextStart = i;
            }

            if(haystack.charAt(i) == needle.charAt(j)) {
                if(start == -1) start = i;
                i++;
                j++;
                if(j == lenNeedle) {
                    break;
                }
            }else{
                j = 0;
                i = nextStart == -1 ? i + 1 : nextStart;
                nextStart = -1;
                start = -1;
            }
        }

        return j == lenNeedle ? start : -1;

    }

    // This only works if the size of haystack and needle is small
    public int strStr1(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int lenHayStack = haystack.length();
        int lenNeedle = needle.length();
        if(lenNeedle > lenHayStack) return -1;

        Map<List<Integer>, Integer> dp = new HashMap<>();

        for(int y = 1 ; y <= lenNeedle; y ++) {
            for(int x = 1 ; x <= lenHayStack; x ++) {
                if(haystack.charAt(x-1) == needle.charAt(y-1)) {
                    int lastLen = dp.getOrDefault(List.of(x-1, y-1), 0);
                    if(lastLen + 1 == lenNeedle) return x - lenNeedle;
                    dp.put(List.of(x, y), lastLen + 1);
                }
            }
        }

        return -1;
    }

    // Optimized solution
    public int strStr2(String haystack, String needle) {
        if(needle.isEmpty()) return 0;

        final var indices = new ArrayList<Integer>();
        int lenHayStack = haystack.length();
        int lenNeedle = needle.length();

        if(lenNeedle > lenHayStack) return -1;

        for(int i = 0 ; i <= lenHayStack - lenNeedle ; i ++) {
            if(haystack.charAt(i) == needle.charAt(0) && haystack.charAt(i + lenNeedle - 1) == needle.charAt(lenNeedle - 1)) {
                indices.add(i);
            }
        }

        for(int index : indices) {
            boolean found = true;
            for(int i = 1 ; i < lenNeedle - 1 ; i ++) {
                if(haystack.charAt(index + i) != needle.charAt(i)) {
                    found = false;
                    break;
                }
            }

            if(found) return index;
        }

        return -1;
    }
}
