package com.algomind.leetcode.palindromepairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        Map<String, Integer> reverseMap = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toMap(i -> new StringBuffer(words[i]).reverse().toString(), i -> i));

        var result = new ArrayList<List<Integer>>();

        for(int i = 0 ; i < n ; i ++) {
            String word = words[i];
            int m = word.length();
            if(m == 0) continue;

            for(int j = 0 ; j <= m; j ++) {
                if(isPalindrome(word, j, m - 1)) {
                    String remaining = word.substring(0, j);
                    int foundIndex = reverseMap.getOrDefault(remaining, -1);
                    if(foundIndex != -1 && foundIndex != i) {
                        result.add(List.of(i, foundIndex));
                    }
                }

                if(j != 0 && isPalindrome(word, 0, j - 1)) {
                    String remaining = word.substring(j, m);
                    int foundIndex = reverseMap.getOrDefault(remaining, -1);
                    if(foundIndex != -1 && foundIndex != i) {
                        result.add(List.of(foundIndex, i));
                    }
                }


            }
        }

        return result;
    }

    private boolean isPalindrome(String word, int start, int end) {
        while(start < end) {
            if(word.charAt(start++) != word.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
