package com.algomind.leetcode.easy;

public class BestTimeToBuySellStock2 {
    public int maxProfit(int[] prices) {
        int i = 0 ;
        int totalProfit = 0;

        while(i < prices.length - 1) {
            int maxProfit = 0;
            int j = i + 1;
            while(j <= prices.length - 1 && prices[i] < prices[j]) {
                int potentialProfit = prices[j] - prices[i];
                if(potentialProfit <= maxProfit) break;
                maxProfit = potentialProfit;
                j++;
            }

            totalProfit += maxProfit;
            i = j;
        }

        return totalProfit;
    }
}
