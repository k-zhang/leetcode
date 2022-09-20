package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSortedVowelStrings {
    public int countSortedVowelStrings(int n) {
        int[][] dp = new int[n][5];

        for(int i = 0 ; i < 5 ; i ++) dp[0][i] = 1;

        int previousSum = 5;
        for(int i = 1 ; i < n; i++) {
            int m = i + 1;

            dp[i][0] = 1;
            dp[i][1] = m;
            dp[i][2] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][3] = previousSum - dp[i-1][4];
            dp[i][4] = previousSum;

            previousSum = 1 + m + dp[i][2] + dp[i][3] + dp[i][4];
        }

        return dp[n-1][0] + dp[n-1][1] + dp[n-1][2] + dp[n-1][3] + dp[n-1][4];
    }

    public void listAllSortedVowels(int n) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        List<String> lastResult = List.of("a", "e", "i", "o", "u");

        for(int r = 1 ; r < n; r ++) {
            List<String> newResult = new ArrayList<>();
            for(int i = 0 ; i < lastResult.size(); i ++) {
                for (int j = 0; j < 5; j++) {
                    String temp = lastResult.get(i);
                    if (temp.charAt(temp.length() - 1) <= vowels[j]) {
                        newResult.add(temp + vowels[j]);
                    }
                }
            }

            lastResult = newResult;
        }

        System.out.println("--------------");
        System.out.println("n = " + n);
        System.out.println("result = " + lastResult.size());
        System.out.println("strings = " + Arrays.toString(lastResult.toArray()));

        Map<String, Long> analysis = analyse(lastResult);
        printMap(analysis);
        System.out.println("--------------");
    }

    public Map<String, Long> analyse(List<String> result) {
        return result.stream().map(s -> s.substring(s.length() - 1)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        CountSortedVowelStrings c = new CountSortedVowelStrings();
        for(int i = 1 ; i <= 8 ; i ++) {
            c.listAllSortedVowels(i);
        }
    }

    private void printMap(Map<String, Long> map) {
        System.out.println("a  :" + map.get("a"));
        System.out.println("e  :" + map.get("e"));
        System.out.println("i  :" + map.get("i"));
        System.out.println("o  :" + map.get("o"));
        System.out.println("u  :" + map.get("u"));
    }
}
