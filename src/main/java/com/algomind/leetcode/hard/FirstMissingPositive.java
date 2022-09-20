package com.algomind.leetcode.hard;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean foundOne = false;
        for(int i = 0 ; i < nums.length ; i ++ ) {
            if(nums[i] == 1) {
                foundOne = true;
                continue;
            }

            if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        if(!foundOne) return 1;

        for(int i = 0 ; i < nums.length ; i ++ ) {
            int absNum = Math.abs(nums[i]);

            if(nums[absNum - 1] > 0) {
                nums[absNum - 1] = -nums[absNum - 1];
            }
        }

        for(int i = 0 ; i < nums.length ; i ++ ) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
