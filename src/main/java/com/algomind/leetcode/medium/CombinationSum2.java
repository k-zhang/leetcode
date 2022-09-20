package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        var path = new LinkedList<Integer>();

        Arrays.sort(candidates);
        recursion(candidates, 0, target, result, path);

        return result;
    }

    private void recursion(int[] candidate, int index, int remain, List<List<Integer>> result, LinkedList<Integer> path) {
        if(remain == 0) {
            result.add(new ArrayList<>(path));
            System.out.println("Selected:" + path);
            return;
        }

        int lastPop = -1;
        for(int i = index ; i < candidate.length && remain >= candidate[i] ; i ++) {
            if(path.isEmpty() && i - 1 >= 0 && candidate[i] == candidate[i-1]) {
                System.out.println("Jump off A:" + candidate[i]);
                continue;
            }

            if(lastPop == candidate[i]) {
                System.out.println("Jump off B:" + candidate[i]);
                continue;
            }

            path.add(candidate[i]);
            System.out.println("Path (Add " + candidate[i] + ")   :" + path);
            recursion(candidate, i+1, remain - candidate[i], result, path);
            lastPop = path.removeLast();
            System.out.println("Path (Remove " + lastPop + "):" + path);
        }
    }
}
