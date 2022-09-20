package com.algomind.leetcode.easy;

import java.util.HashMap;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1;

        var trustMap = new HashMap<Integer, Integer>();
        int judge = -1;
        for (int[] pair : trust) {
            trustMap.put(pair[0], -1);
            if(judge == pair[0]) judge = -1;

            var trustCount = trustMap.merge(pair[1], 1, (v1, v2) -> v1 != -1 ? v1 + v2 : v1);
            if (trustCount == n - 1) judge = pair[1];
        }

        return judge;
    }

    public int findJudge1(int n, int[][] trust) {
        if(n == 1) return 1;

        var score = new int[n + 1];

        int judge = -1;
        for (int[] pair : trust) {
            score[pair[0]] = -1;
            if(judge == pair[0]) judge = -1;

            score[pair[1]] += 1;

            if(score[pair[1]] == n - 1) judge = pair[1];
        }

        return judge;
    }
}
