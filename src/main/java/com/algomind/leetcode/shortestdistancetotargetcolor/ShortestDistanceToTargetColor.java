package com.algomind.leetcode.shortestdistancetotargetcolor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortestDistanceToTargetColor {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        var n = colors.length;

        var mapOfTree = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.groupingBy(i -> colors[i], HashMap::new, Collectors.toCollection(TreeSet::new)));

        var results = new ArrayList<Integer>();
        for (int[] query : queries) {
            var indexSet = mapOfTree.getOrDefault(query[1], null);
            if (indexSet == null) {
                results.add(-1);
            } else {
                var ceiling = indexSet.ceiling(query[0]);
                var floor = indexSet.floor(query[0]);
                results.add(calculateDistance(query[0], ceiling, floor));
            }
        }

        return results;
    }

    private Integer calculateDistance(int index, Integer ceiling, Integer floor) {
        if(ceiling == null) return index - floor;
        else if(floor == null) return ceiling - index;
        else return Math.min(ceiling - index, index - floor);
    }
}
