package com.algomind.leetcode.easy;

// Dynamic Programming
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 1 ; i < prices.length ; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[i - 1]);
            }

            prices[i] = Math.min(prices[i-1], prices[i]);
        }

        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1 ; i < prices.length ; i ++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }
}
