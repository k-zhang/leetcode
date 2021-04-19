package com.algomind.leetcode.jumpgame;

import java.util.stream.IntStream;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        int[] zeroIndices = IntStream.rangeClosed(0, nums.length - 2).filter(i -> nums[i] == 0).toArray();
        if(zeroIndices.length == 0) return true;

        for(int zeroIndex : zeroIndices) {
            boolean skippedZero = false;
            for(int i = zeroIndex - 1 ; i >= 0 ; i --) {
                if(nums[i] > zeroIndex - i) {
                    skippedZero = true;
                    break;
                }
            }

            if(!skippedZero) return false;
        }

        return true;
    }

    public boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
