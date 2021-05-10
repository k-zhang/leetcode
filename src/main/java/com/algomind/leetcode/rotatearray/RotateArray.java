package com.algomind.leetcode.rotatearray;

import java.util.Arrays;

public class RotateArray {
    // No additional memory
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - k - 1);
        swap(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    // Using additional memory
    public void rotate1(int[] nums, int K) {
        int k = K % nums.length;
        if(k == 0) return;

        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        for(int i = 0 ; i < nums.length ; i ++) {
            nums[(i+k) %numsCopy.length] = numsCopy[i];
        }
    }

    // Circular movement
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;

        int totalMove = 0;

        for(int start = 0 ; totalMove < nums.length ; start ++) {
            int current = start;
            int carriedForward = nums[current];

            do {
                int moveToIndex = (current + k) % nums.length;
                int temp = nums[moveToIndex];
                nums[moveToIndex] = carriedForward;
                carriedForward = temp;
                current = moveToIndex;
                totalMove++;
            }while (current != start);
        }
    }
}