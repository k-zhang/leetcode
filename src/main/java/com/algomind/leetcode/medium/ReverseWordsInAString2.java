package com.algomind.leetcode.medium;

public class ReverseWordsInAString2 {
    public void reverseWords(char[] s) {
        int start = 0;

        while(start <= s.length) {
            int end = start;
            while(end + 1 < s.length && s[end + 1] != ' ') end ++;
            reverse(s, start, end);
            start = end + 2;
        }

        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start ++;
            end --;
        }
    }
}
