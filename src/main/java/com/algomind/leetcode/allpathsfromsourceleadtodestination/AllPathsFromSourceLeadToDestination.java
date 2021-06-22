package com.algomind.leetcode.allpathsfromsourceleadtodestination;

import java.util.*;
import java.util.stream.Collectors;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        var pathMap = Arrays.stream(edges).collect(Collectors.groupingBy(edge -> edge[0]));

        Set<Integer> tobeExamined = new HashSet<>();
        tobeExamined.add(source);

        Set<Integer> visited = new HashSet<>();

        return doSearch(pathMap, tobeExamined, visited, destination);
    }

    private boolean doSearch(Map<Integer, List<int[]>> pathMap, Set<Integer> tobeExamined, Set<Integer> visited, int destination) {
        boolean result = true;
        for(Integer node : tobeExamined) {
            List<int[]> paths = pathMap.get(node);
            if(paths == null) {
                result &= node == destination;
                if(!result) return false;
                continue;
            }

            Set<Integer> myVisited = new HashSet<>(visited);
            myVisited.add(node);

            var nextSteps = paths.stream().map(path -> path[1]).collect(Collectors.toSet());
            if(containsLoop(nextSteps, visited)) return false;

            result &= doSearch(pathMap, nextSteps, myVisited, destination);
            if(!result) return false;
        }

        return result;
    }

    private boolean containsLoop(Set<Integer> nextSteps, Set<Integer> visited) {
        Set<Integer> intersection = new HashSet<>(nextSteps);
        intersection.retainAll(visited);
        return !intersection.isEmpty();
    }
}
