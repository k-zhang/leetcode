package com.algomind.leetcode.isomorphicstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++) {
            var replacement = map.get(s.charAt(i));
            if(replacement != null) {
                if(replacement != t.charAt(i)) return false;
            }else{
                if(mapped.contains(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
                mapped.add(t.charAt(i));
            }
        }

        return true;
    }

    // Cleaner solution
    public boolean isIsomorphic1(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
