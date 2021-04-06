package com.algomind.leetcode.combinationsum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Backtrack (see note)
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        var potentialResult = new LinkedList<Integer>();

        recursion(candidates, 0, target, result, potentialResult);

        return result;
    }

    private void recursion(int[] candidate, int index, int remain, List<List<Integer>> result, LinkedList<Integer> potentialResult) {
        if(remain < 0) return;
        if(remain == 0) {
            result.add(new ArrayList<>(potentialResult));
            return;
        }

        for(int i = index; i < candidate.length ; i++) {
            potentialResult.add(candidate[i]);
            recursion(candidate, i, remain - candidate[i], result, potentialResult);
            potentialResult.removeLast();
        }
    }
}
