package com.algomind.leetcode.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // DP
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int result = 1;
        for(int i = 1 ; i < n ; i ++) {
            for(int j = 0 ; j < i ; j ++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }

    // Binary Search
    public int lengthOfLIS1(int[] nums) {
        var sub = new ArrayList<Integer>();
        sub.add(nums[0]);

        for(int i = 1 ; i < nums.length ; i ++) {
            if(nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            }else{
                int index = binarySearch(sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }

        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0 , right = sub.size() - 1;

        while(left < right) {
            int mid = (right + left) / 2;
            if(sub.get(mid) == num) {
                return mid;
            }

            if(num > sub.get(mid)) {
                left = mid + 1;
            }else{
                right = mid; // Note this cannot be mid - 1
            }
        }

        return left;
    }
}
