package com.algomind.leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
