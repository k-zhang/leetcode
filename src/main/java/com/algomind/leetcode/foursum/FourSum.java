package com.algomind.leetcode.foursum;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return List.of();
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 2 ; i ++) {
            if(i == 0 || nums[i-1] != nums[i]) {
                for(int j = i + 1 ; j < nums.length - 1 ; j ++) {
                    if(j-1 == i || nums[j-1] != nums[j]) {
                        twoSum(nums, i, j, target, res);
                    }
                }
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, int j, int target, List<List<Integer>> res) {
        Set<Integer> observed = new HashSet<>();
        for(int k = j+1 ; k < nums.length ; k++) {
            int complement = target -nums[i] - nums[j] - nums[k];
            if(observed.contains(complement)) {
                res.add(List.of(nums[i], nums[j], nums[k], complement));
                while(k+1 < nums.length && nums[k + 1] == nums[k]) k++;
            }

            observed.add(nums[k]);
        }
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
                if (s.contains(target - nums[i]))
                    res.add(Arrays.asList(target - nums[i], nums[i]));
            s.add(nums[i]);
        }
        return res;
    }
}
