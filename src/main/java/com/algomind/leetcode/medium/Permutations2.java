package com.algomind.leetcode.medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var permute = new LinkedList<Integer>();
        var frequency = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        backtracking(nums.length, frequency, permute, result, 0);

        return result;
    }

    private void backtracking(int length, Map<Integer, Long> frequency, LinkedList<Integer> permute, ArrayList<List<Integer>> result, int first) {
        if(first == length) {
            result.add(new ArrayList<>(permute));
        }

        for(var entry : frequency.entrySet()) {
            if(entry.getValue() == 0) {
                continue;
            }

            permute.add(entry.getKey());
            frequency.compute(entry.getKey(), (k, v) -> v - 1);
            backtracking(length, frequency, permute, result, first + 1);
            permute.removeLast();
            frequency.compute(entry.getKey(), (k, v) -> v + 1);
        }
    }
}
