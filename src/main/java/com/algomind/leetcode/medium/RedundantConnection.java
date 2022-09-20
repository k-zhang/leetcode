package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        List<Set<Integer>> groups = new ArrayList<>();

        int[] result = null;
        for (int[] edge : edges) {
            Set<Integer> match1 = null;
            Set<Integer> match2 = null;
            int index2 = -1;

            for(var i = 0 ; i < groups.size() ; i++) {
                Set<Integer> group = groups.get(i);
                if(group.contains(edge[0])) match1 = group;
                if(group.contains(edge[1])) {
                    index2 = i;
                    match2 = group;
                }
            }

            if(match1 != null && match1 == match2) {
                result = edge;
            }else if(match1 != null && match2 != null && match1 != match2) {
                groups.remove(index2);
                match1.addAll(match2);
            }else if(match1 != null && match2 == null) {
                match1.add(edge[0]);
                match1.add(edge[1]);
            }else if(match1 == null && match2 != null) {
                match2.add(edge[0]);
                match2.add(edge[1]);
            }else{
                Set<Integer> newGroup = new HashSet<>();
                newGroup.add(edge[0]);
                newGroup.add(edge[1]);
                groups.add(newGroup);
            }
        }

        return result;
    }

    public int[] findRedundantConnection1(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }

        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
//      The above code can be simplified into
//      return index == parent[index] ? index : (parent[index] = find(parent, parent[index]));
    }
}
