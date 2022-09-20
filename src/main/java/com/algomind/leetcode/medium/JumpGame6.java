package com.algomind.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

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

    // Fastest
    public int maxResult1(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> dq = new LinkedList<>();
        dq.offerLast(new int[] { 0, score });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst()[0] < i - k) {
                dq.pollFirst();
            }
            score = dq.peek()[1] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score >= dq.peekLast()[1]) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { i, score });
        }
        return score;
    }

    public int maxResult12(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[] { nums[0], 0 });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (priorityQueue.peek()[1] < i - k) {
                priorityQueue.remove();
            }
            score[i] = nums[i] + score[priorityQueue.peek()[1]];
            priorityQueue.add(new int[] { score[i], i });
        }
        return score[n - 1];
    }
}
