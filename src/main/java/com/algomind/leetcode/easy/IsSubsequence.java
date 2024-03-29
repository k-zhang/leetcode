package com.algomind.leetcode.easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i = 0 ; i <= s.length() ; i++) dp[i][0] = 0;
        for(int i = 0 ; i <= t.length() ; i++) dp[0][i] = 0;

        for(int i = 1 ; i <= s.length() ; i++) {
            for(int j = 1 ; j <= t.length() ; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return s.length() == dp[s.length()][t.length()];
    }
}
