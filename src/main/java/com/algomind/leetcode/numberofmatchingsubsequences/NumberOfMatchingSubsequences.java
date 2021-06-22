package com.algomind.leetcode.numberofmatchingsubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    // Brute Force (Not accepted)
    public int numMatchingSubsequences(String s, String[] words) {
        int result = 0;
        for (String word : words) {
            int current = -1;
            boolean isSubsequence = true;
            for (int i = 0; i < word.length(); i++) {
                boolean found = false;
                for (int j = current + 1; j < s.length(); j++) {
                    if (word.charAt(i) == s.charAt(j)) {
                        found = true;
                        current = j;
                        break;
                    }
                }

                if (!found) {
                    isSubsequence = false;
                    break;
                }
            }

            if (isSubsequence) result++;
        }

        return result;
    }

    public int numMatchingSubsequences1(String s, String[] words) {
        var charMap = generateCharMap(s);

        var wordIndices = new HashMap<Character, Integer>();
        int result = 0;
        for(String word : words) {
           result += checkWord(word, charMap, wordIndices);
        }

        return result;
    }

    private int checkWord(String word, Map<Character, List<Integer>> charMap, HashMap<Character, Integer> wordIndices) {
        wordIndices.clear();

        int current = -1;
        for(int i = 0 ; i < word.length() ; i ++) {
            char c = word.charAt(i);
            var indices = charMap.get(c);
            if(indices == null) return 0;

            Integer prevIndex = wordIndices.get(c);
            int searchIndex = prevIndex == null ? 0 : prevIndex;

            while(searchIndex < indices.size()) {
                int charIndex = indices.get(searchIndex);
                if(charIndex > current) {
                    current = charIndex;
                    wordIndices.put(c, searchIndex + 1);
                    break;
                }else{
                    searchIndex ++;
                }
            }

            if(searchIndex >= indices.size()) return 0;
        }

        return 1;
    }

    private Map<Character, List<Integer>> generateCharMap(String s) {
        var charMap = new HashMap<Character, List<Integer>>();
        for(int i = 0 ; i < s.length() ; i ++) {
            var indices = charMap.computeIfAbsent(s.charAt(i), (c) -> new ArrayList<>());
            indices.add(i);
        }
        return charMap;
    }
}
