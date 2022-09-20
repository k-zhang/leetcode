package com.algomind.leetcode.easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        var result = nums[0] == 1 ? 1 : 0;
        for(int i = 1 ; i < nums.length ; i ++) {
            if(nums[i] == 1) {
                nums[i] = nums[i - 1] + 1;
                result = Math.max(nums[i], result);
            }
        }
        return result;
    }
}
