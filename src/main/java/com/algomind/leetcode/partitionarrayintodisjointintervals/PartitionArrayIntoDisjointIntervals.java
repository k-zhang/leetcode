package com.algomind.leetcode.partitionarrayintodisjointintervals;

public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        for(int i = 1 ; i < n ; i ++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i]);
        }

        dp2[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i --) {
            dp2[i] = Math.min(dp2[i + 1], nums[i]);
        }

        int result = -1;
        for(int i = 1 ; i < n  ; i ++) {
            if(dp1[i - 1] <= dp2[i]) {
                result = i;
                break;
            }
        }

        return result;
    }

    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i --) {
            dp[i] = Math.min(dp[i + 1], nums[i]);
        }

        int result = -1;
        int max = nums[0];
        for(int i = 1 ; i < n  ; i ++) {
            if(max <= dp[i]) {
                result = i;
                break;
            }
            max = Math.max(max, nums[i]);
        }

        return result;
    }

    public int partitionDisjoint2(int[] nums) {
        int leftMax = nums[0], max=nums[0], leftLen = 0;

        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] < leftMax) {
                leftLen = i;
                leftMax = Math.max(leftMax,max);
            }

            max = Math.max(max,nums[i]);
        }

        return leftLen + 1;
    }
}
