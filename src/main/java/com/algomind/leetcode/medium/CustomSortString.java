package com.algomind.leetcode.medium;

public class CustomSortString {
    public String customSortString(String order, String str) {
        if(order.length() == 0) return str;
        if(str.length() == 0) return str;

        var map = new int[26];

        for(int i = 0 ; i < str.length() ; i ++) {
            map[str.charAt(i) - 'a'] ++;
        }

        var sb = new StringBuilder();
        for(int i = 0 ; i < order.length() ; i ++) {
            int index = order.charAt(i) - 'a';
            for(int j = 0 ; j < map[index] ; j ++) sb.append(order.charAt(i));
            map[index] = 0;
        }

        for(int i = 0 ; i < map.length ; i ++) {
            for(int j = 0 ; j < map[i] ; j ++) sb.append((char)('a' + i));
        }

        return sb.toString();
    }
}
