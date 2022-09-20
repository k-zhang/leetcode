package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        result.add(List.of());

        doFindSubSets(nums, 0, nums.length - 1, result);
        return result;
    }

    private void doFindSubSets(int[] nums, int start, int end, List<List<Integer>> result) {
        if(start == end) {
            result.add(List.of(nums[start]));
            return;
        }

        doFindSubSets(nums, start, end - 1, result);

        int len = result.size();
        for(int i = 0 ; i < len ; i ++) {
            var newSet = new ArrayList<>(result.get(i));
            newSet.add(nums[end]);
            result.add(newSet);
        }
    }

    // An interesting method of using bitmap by Donald E. Knuth.
    public List<List<Integer>> subsets1(int[] nums) {
        var output = new ArrayList<List<Integer>>();
        var n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            var bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            var curr = new ArrayList<Integer>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
