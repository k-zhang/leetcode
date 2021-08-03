package com.algomind.leetcode.subsets2;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        var result = new HashSet<ResultEntry>();
        result.add(new ResultEntry());

        doFindSubSets(nums, 0, nums.length - 1, result);

        var finalResult = new ArrayList<List<Integer>>();
        for(var resultEntry : result) {
            finalResult.add(Arrays.stream(resultEntry.result).boxed().collect(Collectors.toList()));
        }

        return finalResult;
    }

    private void doFindSubSets(int[] nums, int start, int end, Set<ResultEntry> result) {
        if(start == end) {
            result.add(new ResultEntry(nums[start]));
            return;
        }

        doFindSubSets(nums, start, end - 1, result);

        var newSet = new HashSet<ResultEntry>();
        for(var r : result) {
            var newR = new ResultEntry(r.result, nums[end]);
            newSet.add(newR);
        }

        result.addAll(newSet);
    }

    public static class ResultEntry {
        int[] result;

        public ResultEntry() {
            result = new int[0];
        }

        public ResultEntry(int newValue) {
            result = new int[]{newValue};
            Arrays.sort(result);
        }

        public ResultEntry(int[] current) {
            result = Arrays.copyOf(current, current.length);
            Arrays.sort(result);
        }

        public ResultEntry(int[] current, int newValue) {
            result = Arrays.copyOf(current, current.length + 1);
            result[current.length] = newValue;
            Arrays.sort(result);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ResultEntry that = (ResultEntry) o;
            return Arrays.equals(result, that.result);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(result);
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        subsetsWithDupHelper(subsets, currentSubset, nums, 0);
        return subsets;
    }

    private void subsetsWithDupHelper(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index) {
        // Add the subset formed so far to the subsets list.
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // If the current element is a duplicate, ignore.
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            subsetsWithDupHelper(subsets, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
