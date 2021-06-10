package com.algomind.leetcode.jumpgame6;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGame6 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> windowIndices = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            while (!windowIndices.isEmpty() && dp[i - 1] >= dp[windowIndices.peekLast()]) {
                windowIndices.pollLast();
            }

            windowIndices.offerLast(i - 1);
            if (windowIndices.peekFirst() < i - k) {
                windowIndices.pollFirst();
            }

            dp[i] = dp[windowIndices.peekFirst()] + nums[i];
        }

        return dp[nums.length - 1];
    }
}
