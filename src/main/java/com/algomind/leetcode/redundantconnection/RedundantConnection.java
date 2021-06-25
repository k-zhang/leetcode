package com.algomind.leetcode.redundantconnection;

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
}
