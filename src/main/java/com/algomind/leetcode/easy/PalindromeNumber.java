package com.algomind.leetcode.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int rev = 0;
        int y = x;
        while(y != 0) {
            int pop = y % 10;
            y = y / 10;

            if((rev > Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return false;

            rev = rev * 10 + pop;
        }

        return rev == x;
    }
}
