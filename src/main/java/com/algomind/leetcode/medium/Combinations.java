package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    private final List<List<Integer>> result = new ArrayList<>();
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backtrack(1, new LinkedList<>());
        return result;
    }

    private void backtrack(int first, LinkedList<Integer> candidate) {
        if(candidate.size() == k) {
            result.add(new ArrayList<>(candidate));
        }

        for(int i = first ; i <= n ; i++) {
            candidate.add(i);
            backtrack(i + 1, candidate);
            candidate.removeLast();
        }
    }
}
