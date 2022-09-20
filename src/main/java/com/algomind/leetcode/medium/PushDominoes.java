package com.algomind.leetcode.medium;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        char[] dp1 = new char[d.length];
        char[] dp2 = new char[d.length];

        for (int i = 0; i < d.length; i++) {
            if (d[i] == 'L') dp1[i] = 'L';
            else if (d[i] == 'R') dp1[i] = 'R';
            else if (d[i] == '.') {
                if (i - 1 >= 0 && dp1[i - 1] == 'R') dp1[i] = 'R';
                else dp1[i] = '.';
            }
        }

        for (int i = d.length - 1; i >= 0; i--) {
            if (d[i] == 'R') dp2[i] = 'R';
            else if (d[i] == 'L') dp2[i] = 'L';
            else if (d[i] == '.') {
                if (i + 1 <= d.length - 1 && dp2[i + 1] == 'L') dp2[i] = 'L';
                else dp2[i] = '.';
            }
        }

        char[] result = new char[d.length];
        int i = 0, count = 1;
        while (i < d.length) {
            if (dp1[i] == '.' && dp2[i] == '.') {
                result[i] = '.';
            } else if (dp1[i] == '.' && dp2[i] == 'L') {
                result[i] = 'L';
            } else if (dp1[i] == 'R' && dp2[i] == '.') {
                result[i] = 'R';
            } else if (dp1[i] == 'R' && dp2[i] == 'R') {
                result[i] = 'R';
            } else if (dp1[i] == 'L' && dp2[i] == 'L') {
                result[i] = 'L';
            } else {
                int j = i;
                while (dp1[j] == 'R' && dp2[j] == 'L') j++;
                count = j - i;
                if (count % 2 != 0) {
                    for (int k = i; k < i + count / 2; k++) result[k] = 'R';
                    result[i + count / 2] = '.';
                    for (int k = i + count / 2 + 1; k < i + count; k++) result[k] = 'L';
                } else {
                    for (int k = i; k < i + count / 2; k++) result[k] = 'R';
                    for (int k = i + count / 2; k < i + count; k++) result[k] = 'L';
                }
            }

            i += count;
            count = 1;
        }

        return new String(result);
    }

    public String pushDominoes1(String dominoes) {
        char[] d = dominoes.toCharArray();
        int[] diff = new int[d.length];

        int weight = 0;
        for(int i = 0 ; i < d.length ; i ++) {
            if(d[i] == 'L') weight = 0;
            else if(d[i] == 'R') weight = d.length;
            else if(d[i] == '.') weight = Math.max(weight - 1 , 0);

            diff[i] = weight;
        }

        weight = 0;
        for(int i = d.length - 1 ; i >= 0 ; i --) {
            if(d[i] == 'L') weight = d.length;
            else if(d[i] == 'R') weight = 0;
            else if(d[i] == '.') weight = Math.max(weight - 1 , 0);

            diff[i] -= weight;

            if(diff[i] < 0) d[i] = 'L';
            else if(diff[i] > 0) d[i] = 'R';
            else d[i] = '.';
        }

        return new String(d);
    }
}
