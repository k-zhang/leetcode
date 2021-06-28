package com.algomind.leetcode.candy;

import java.util.Arrays;

public class Candy {
    // Brute Force
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (ratings[j] > ratings[j + 1]) {
                        if (candies[j] == candies[j + 1]) {
                            candies[j]++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return Arrays.stream(candies).sum();
    }

    // Two Array
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];

        leftToRight[0] = 1;
        for(int i = 1 ; i < n ; i ++) {
            if(ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }else{
                leftToRight[i] = 1;
            }
        }

        rightToLeft[n - 1] = 1;
        for(int i = n - 2 ; i >= 0 ; i --) {
            if(ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }else{
                rightToLeft[i] = 1;
            }
        }

        int result = 0;
        for(int i = 0 ; i < n ; i ++) {
            result += Math.max(leftToRight[i], rightToLeft[i]);
        }
        return result;
    }

    // Slope
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
