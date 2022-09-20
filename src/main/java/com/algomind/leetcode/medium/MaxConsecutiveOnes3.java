package com.algomind.leetcode.medium;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int max = 0;

        while(right < nums.length) {
            if(nums[right] != 0) right ++;
            else if(k > 0){
                k --;
                right ++;
            }else {
                if(nums[left] == 0) k++;
                left++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }

    public int longestOnes1(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for(; right < nums.length ; right++) {
            if(nums[right] == 0) k--;

            if(k < 0) {
                left ++;
                if(nums[left - 1] == 0) k ++;
            }
        }

        return right - left;
    }
}
