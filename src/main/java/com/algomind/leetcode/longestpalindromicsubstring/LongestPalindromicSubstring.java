package com.algomind.leetcode.longestpalindromicsubstring;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) return "";

        int start = 0, end = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int length = Math.max(len1, len2);
            if(length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        if(start == end) return Character.toString(s.charAt(0));
        else return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return right - left - 1;
    }
}
