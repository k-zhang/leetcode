package com.algomind.leetcode.hard;

public class TrappingRainWater {
    // DP
    public int trap(int[] height) {
        if(height.length < 3) return 0;

        int len = height.length;
        
        int[] dpLeft = new int[len];
        dpLeft[0] = height[0];
        for(int i = 1 ; i < len ; i++) {
            dpLeft[i] = Math.max(height[i], dpLeft[i-1]);
        }

        int[] dpRight = new int[len];
        dpRight[len - 1] = height[len - 1];
        for(int i = len - 2 ; i >= 0 ; i--) {
            dpRight[i] = Math.max(height[i], dpRight[i+1]);
        }

        int result = 0;
        for(int i = 1 ; i < len - 1; i ++) {
            result += Math.min(dpLeft[i], dpRight[i]) - height[i];
        }

        return result;
    }

    // Double pointers
    public int trap1(int[] height) {
        if(height.length < 3) return 0;

        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;

        while(left <  right) {
            if(height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left ++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right --;
            }
        }

        return result;
    }
}
