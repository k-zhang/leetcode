package com.algomind.leetcode.plusone;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length -1 ; i >=0 ; i--) {
            if(digits[i] + 1 < 10) {
                digits[i] += 1;
                break;
            }else{
                digits[i] = 0;
            }
        }

        if(digits[0] == 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            digits = newDigits;
        }

        return digits;
    }
}
