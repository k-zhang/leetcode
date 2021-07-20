package com.algomind.leetcode.shuffleanarray;

import java.util.Random;

public class Solution {
    private final int[] nums;
    private final Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] result = nums.clone();

        for(int i = result.length - 1 ; i > 0 ; i --) {
            int j = random.nextInt(i + 1);
            swap(result, i, j);
        }

        return result;
    }

    private void swap(int[] nums, int src, int dest) {
        int temp = nums[dest];
        nums[dest] = nums[src];
        nums[src] = temp;
    }
}
