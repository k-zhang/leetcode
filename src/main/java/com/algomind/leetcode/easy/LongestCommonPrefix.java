package com.algomind.leetcode.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];

        StringBuilder sb = new StringBuilder();

        String first = strs[0];
        if (first.equals("")) return "";

        int index = 0;
        while (true) {
            if (index == first.length()) return sb.toString();
            char c = first.charAt(index);

            for (var i = 1; i < n; i++) {
                if (index == strs[i].length()) return sb.toString();

                char current = strs[i].charAt(index);
                if (c != current) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs.length == 1) return strs[0];
        for(int i = 0 ; i < strs[0].length() ; i ++) {
            char c = strs[0].charAt(i);
            for(int j = 1 ; j < strs.length ; j ++) {
                if(strs[j].length() == i || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
