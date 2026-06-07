package com.algomind.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Set<Integer>> lookUpMap = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> nums[i], Collectors.mapping(i -> i, Collectors.toSet())));

        for(int i = 0 ; i < nums.length; i++) {
            int counterpart = target - nums[i];

            Set<Integer> counterpartIndices = lookUpMap.get(counterpart);
            if(counterpartIndices != null && (!counterpartIndices.contains(i) || counterpartIndices.size() > 1)) {
                counterpartIndices.remove(i);
                Integer indexRequired = counterpartIndices.stream().findFirst().get();
                return indexRequired < i ? new int[]{indexRequired, i} : new int[]{i, indexRequired};
            }
        }

        throw new IllegalArgumentException("The input data should have at least one valid result.");
    }
}
