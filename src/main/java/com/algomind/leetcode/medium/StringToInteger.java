package com.algomind.leetcode.medium;

public class StringToInteger {
    public int myAtoi(String s) {
        final int MAX_LENGTH = 10;
        final String MIN_NUMBER_CHARACTER = "2147483648";
        final String MAX_NUMBER_CHARACTER = "2147483647";

        if(s.isBlank()) return 0;

        s = s.trim();
        int sign;
        if(s.charAt(0) == '-'){
            sign = -1;
            if(s.length() == 1) return 0;
            s = s.substring(1);
        }else if(s.charAt(0) == '+'){
            sign = 1;
            if(s.length() == 1) return 0;
            s = s.substring(1);
        }else{
            sign = 1;
        }

        // Remove leading zeros
        int startIndex = 0;
        while(startIndex < s.length() && s.charAt(startIndex) == '0') {
            startIndex ++;
        }
        if(startIndex == s.length()) {
            return 0;
        }

        if(startIndex != 0) {
            s = s.substring(startIndex);
        }

        // Extract the number parts
        int index = 0;
        while(index < s.length()) {
            if(!Character.isDigit(s.charAt(index))) {
                break;
            }
            index++;
        }

        if(index == 0) return 0;

        String numericString = index == s.length()? s : s.substring(0, index);

        if(numericString.length() > MAX_LENGTH){
            return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }else if(numericString.length() == MAX_LENGTH) {
            if(sign == -1) {
                if(numericString.compareTo(MIN_NUMBER_CHARACTER) >= 0) {
                    return Integer.MIN_VALUE;
                }
            }else{
                if(numericString.compareTo(MAX_NUMBER_CHARACTER) >= 0) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return Integer.parseInt(numericString) * sign;
    }
}
