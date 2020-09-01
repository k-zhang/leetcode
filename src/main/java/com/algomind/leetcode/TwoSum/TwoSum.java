package com.algomind.leetcode.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            int want = target - nums[i];
            if(map.containsKey(want)) {
                return new int[]{map.get(want), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }
}
