package com.algomind.leetcode.hard;

import java.util.Arrays;

public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;

        if (n == 1) return 5;

        long[][] dp = new long[n][5];
        Arrays.fill(dp[0], 1);

        for(int i = 1 ; i < n; i ++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD;
            dp[i][3] = dp[i-1][2];
            dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % MOD;
        }

        long result = 0;
        for(int i = 0 ; i < 5 ; i ++) {
            result = (result + dp[n-1][i]) % MOD;
        }

        return (int)result;
    }
}
