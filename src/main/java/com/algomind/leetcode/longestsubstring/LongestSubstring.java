package com.algomind.leetcode.longestsubstring;

import java.util.*;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int current = 0, start = 0;
        Map<Character, Integer> charInSubstring = new HashMap<>();

        int n = s.length();
        while(current < n) {
            if(!charInSubstring.containsKey(s.charAt(current))) {
                charInSubstring.put(s.charAt(current), current);
                current++;
            }else{
                longest = Math.max(longest, current - start);
                start = charInSubstring.get(s.charAt(current)) + 1;
                current = start;
                charInSubstring.clear();
            }
        }

        longest = Math.max(longest, current - start);

        return longest;
    }
}
