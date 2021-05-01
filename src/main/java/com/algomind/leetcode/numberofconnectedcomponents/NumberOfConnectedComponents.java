package com.algomind.leetcode.numberofconnectedcomponents;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0) return n;

        Set<Set<Integer>> groups = new HashSet<>();
        Set<Integer> firstGroup = new HashSet<>(Arrays.asList(edges[0][0], edges[0][1]));
        groups.add(firstGroup);

        int total = firstGroup.size();
        for(int i = 1 ; i < edges.length; i ++) {
            int from = edges[i][0];
            int to = edges[i][1];

            Set<Integer> fromSet = null;
            Set<Integer> toSet = null;

            for(Set<Integer> group : groups) {
                if(group.contains(from)) fromSet = group;
                if(group.contains(to)) toSet = group;
            }

            if(fromSet == null && toSet == null) {
                Set<Integer> newGroup = new HashSet<>(Arrays.asList(from, to));
                groups.add(newGroup);
                total += newGroup.size();
            }else if(fromSet == null && toSet != null) {
                toSet.add(from);
                total += 1;
            }else if(fromSet != null && toSet == null) {
                fromSet.add(to);
                total += 1;
            }else if(fromSet != toSet) {
                fromSet.addAll(toSet);
                toSet.clear();
            }

            // fromSet == toSet. Do nothing
        }

        int size = (int)groups.stream().filter(s -> !s.isEmpty()).count();
        return size + (n - total);
    }
}
