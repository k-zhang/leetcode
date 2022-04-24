package com.algomind.leetcode.romantointeger;

import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> dict = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public int romanToInt(String s) {
        var tempNumber = 0;
        var result = 0;
        var prevNumber = dict.get(s.charAt(s.length()-1));

        for(int i = s.length() - 1 ; i >= 0 ; i --) {
            var number = dict.get(s.charAt(i));
            if(number > prevNumber) {
                result += number + tempNumber;
                tempNumber = 0;
            }else if(number < prevNumber) {
                tempNumber = tempNumber - number;
            }else {
                tempNumber += number;
            }
            prevNumber = number;
        }

        if(tempNumber != 0) {
            result += tempNumber;
        }

        return result;
    }
}
