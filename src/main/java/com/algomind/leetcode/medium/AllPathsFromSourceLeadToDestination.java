package com.algomind.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        var pathMap = Arrays.stream(edges).collect(Collectors.groupingBy(edge -> edge[0]));

        int[] nextSteps = new int[]{source};
        Set<Integer> visited = new HashSet<>();

        return doSearch(pathMap, nextSteps, visited, destination);
    }

    private boolean doSearch(Map<Integer, List<int[]>> pathMap, int[] tobeExamined, Set<Integer> visited, int destination) {
        boolean result = true;
        for(Integer node : tobeExamined) {
            if(visited.contains(node)) return false;

            List<int[]> paths = pathMap.get(node);
            if(paths == null) {
                result &= node == destination;
                if(!result) return false;
                continue;
            }

            var nextSteps = paths.stream().mapToInt(path -> path[1]).toArray();

            visited.add(node);
            result &= doSearch(pathMap, nextSteps, visited, destination);
            if(!result) return false;
            visited.remove(node);
        }

        return result;
    }
}
