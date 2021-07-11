package com.algomind.leetcode.decodeways2;

public class DecodeWays2 {
    public int numDecodings(String s) {
        int M = 1000000007;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;;

        for(int i = 2 ; i <= s.length() ; i ++) {
            int ii = i - 1;
            char current = s.charAt(ii);
            char last = s.charAt(ii - 1);

            if(current == '*') {
                dp[i] = dp[i - 1] * 9;

                if(last == '1') {
                    dp[i] = (dp[i] + dp[i - 2] * 9) % M;
                }else if(last == '2') {
                    dp[i] = (dp[i] + dp[i - 2] * 6) % M;
                }else if (last == '*'){
                    dp[i] = (dp[i] + dp[i - 2] * 15) % M;
                }
            }else{
                dp[i] = current != '0' ? dp[i - 1] : 0;
                if(last == '1') {
                    dp[i] = (dp[i] + dp[i - 2]) % M;
                }else if(last == '2' && current <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]) % M;
                }else if(last == '*') {
                    int factor = current <= '6' ? 2 : 1;
                    dp[i] = (dp[i] + factor * dp[i - 2]) % M;
                }
            }

            dp[i] %= M;
        }

        return (int)dp[s.length()];
    }
}
