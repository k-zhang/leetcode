package com.algomind.leetcode.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, List<Character>> phoneKey =
            Map.of('2', List.of('a', 'b', 'c'),
                   '3', List.of('d', 'e', 'f'),
                   '4', List.of('g', 'h', 'i'),
                   '5', List.of('j', 'k', 'l'),
                   '6', List.of('m', 'n', 'o'),
                   '7', List.of('p', 'q', 'r', 's'),
                   '8', List.of('t', 'u', 'v'),
                   '9', List.of('w', 'x', 'y', 'z'));

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return List.of();

        var result = new ArrayList<String>();
        var combination = new StringBuffer();
        doSearchCombinations(digits, result, combination, digits.length(), 0);
        return result;
    }

    private void doSearchCombinations(String digits, List<String> result, StringBuffer combination, int size, int current) {
        if(current == size) {
            result.add(combination.toString());
            return;
        }

        var currentDigit = digits.charAt(current);
        var characters = phoneKey.get(currentDigit);

        for(var c : characters) {
            combination.append(c);
            doSearchCombinations(digits, result, combination, size, current + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
