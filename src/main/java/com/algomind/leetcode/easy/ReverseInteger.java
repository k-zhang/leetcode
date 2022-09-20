package com.algomind.leetcode.easy;

public class ReverseInteger {
    public int reverse(int x) {
        String s = Integer.toString(x);
        char[] chars = s.toCharArray();
        if(chars.length == 1) return x;

        int start = chars[0] == '-' ? 1 : 0;
        for(int i = start, j = chars.length - 1 ; i <= j ; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        String string = String.valueOf(chars);

        try {
            return Integer.parseInt(string);
        }catch (Exception e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x = x / 10;

            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -1)) return 0;

            rev = rev * 10 + pop;
        }

        return rev;
    }
}
