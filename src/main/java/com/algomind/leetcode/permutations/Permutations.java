package com.algomind.leetcode.permutations;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var permute = new ArrayList<Integer>();
        Arrays.stream(nums).forEach(permute::add);

        backtracking(nums.length, permute, result, 0);

        return result;
    }

    private void backtracking(int length, ArrayList<Integer> permute, ArrayList<List<Integer>> result, int first) {
        if(first == length) {
            result.add(new ArrayList<>(permute));
        }

        for(int i = first ; i < length ; i ++) {
            Collections.swap(permute, first , i);
            backtracking(length, permute, result, first + 1);
            Collections.swap(permute, first, i);
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var permute = new LinkedList<Integer>();

        var used = new boolean[nums.length];

        backtracking1(nums.length, used, nums, permute, result);

        return result;
    }

    private void backtracking1(int length, boolean[] used, int[] nums, LinkedList<Integer> permute, ArrayList<List<Integer>> result) {
        if(permute.size() == length) {
            result.add(new ArrayList<>(permute));
        }

        for(int i = 0 ; i < length ; i ++) {
            if(used[i]) {
                continue;
            }
            permute.add(nums[i]);
            used[i] = true;
            backtracking1(length, used, nums, permute, result);
            if(!permute.isEmpty()) permute.removeLast();
            used[i] = false;
        }
    }
}
