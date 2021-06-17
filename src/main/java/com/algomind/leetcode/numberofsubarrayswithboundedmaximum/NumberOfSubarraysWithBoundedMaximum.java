package com.algomind.leetcode.numberofsubarrayswithboundedmaximum;

public class NumberOfSubarraysWithBoundedMaximum {
    // 2D DP
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        for(int i = 0 ; i < nums.length ; i ++) {
            int prev = 0;
            for (int j = i ; j < nums.length ; j++) {
                int max = Math.max(nums[j], prev);
                if(max >= left && max <= right) {
                    result++;
                    prev = max;
                }else if(max > right) {
                    break;
                }
            }
        }

        return result;
    }

    // Counting
    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left-1);
    }

    public int count(int[] nums, int bound) {
        int ans = 0, cur = 0;
        for (int x : nums) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }

    // DP
    public int numSubarrayBoundedMax2(int[] nums, int left, int right) {
        int lastBreak = -1;
        int lastCount = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                lastBreak = i;
                lastCount = 0;
            } else if (nums[i] < left) {
                ans += lastCount;
            } else {
                lastCount = i - lastBreak;
                ans += lastCount;
            }
        }
        return ans;
    }
}
