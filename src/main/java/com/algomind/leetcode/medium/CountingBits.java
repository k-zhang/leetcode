package com.algomind.leetcode.medium;

import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};

        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;

        int lssi = 1; // last section start index
        int lsl = 1; // Last section length
        int cssi = 1; // Current section start length
        int csl = 1; // Current section length
        int nssn = 2; // Next section start number

        int si = 0;
        for(int i = 2 ; i <= num ; i++) {
            if(i == nssn) {
                lssi = cssi;
                lsl = csl;
                cssi = i;
                csl = nssn;
                nssn = nssn + nssn;
                si = 0;
            }

            if(i < cssi + lsl) {
                dp[i] = dp[lssi++];
            }else{
                dp[i] = dp[cssi + si] + 1;
                si++;
            }
        }

        return dp;
    }
}
