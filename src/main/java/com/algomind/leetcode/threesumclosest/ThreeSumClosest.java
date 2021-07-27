package com.algomind.leetcode.threesumclosest;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int diffAbs = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i ++) {
            for(int j = i + 1 ; j < nums.length-1 ; j++) {
                int complements = target - nums[i] - nums[j];
                int index = Arrays.binarySearch(nums, j+1, nums.length - 1, complements);
                if(index >= 0) {
                    return target;
                }else{
                    int hi = -index-1;
                    int lo = hi - 1 >= j + 1 ? hi - 1 : hi;

                    int diffLow = nums[lo] - complements;
                    int diffHigh = nums[hi] - complements;
                    int toLow = Math.abs(diffLow);
                    int toHigh =  Math.abs(diffHigh);
                    if(toLow < toHigh && toLow < diffAbs) {
                        diff = diffLow;
                        diffAbs = toLow;
                    }else if(toLow >= toHigh && toHigh < diffAbs) {
                        diff = diffHigh;
                        diffAbs = toHigh;
                    }
                }
            }
        }

        return target + diff;
    }
}
