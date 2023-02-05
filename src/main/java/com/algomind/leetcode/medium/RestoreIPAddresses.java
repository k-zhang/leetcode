package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    private final List<String> result = new ArrayList<>();
    private String s;

    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4) return List.of();

        this.s = s;
        doSearch(0, 0, new LinkedList<>());
        return result;
    }

    private void doSearch(int first, int parts, LinkedList<String> candidates) {
        if(parts == 3) {
            candidates.add(s.substring(first));
            if(validCandidate(candidates)) {
                var address = String.join(".", candidates);
                result.add(address);
            }
            candidates.removeLast();
            return;
        }

        for(int i = first + 1 ; i <= s.length() - (3 - parts) ; i ++) {
            candidates.add(s.substring(first, i));
            doSearch(i, parts + 1, candidates);
            candidates.removeLast();
        }
    }

    private boolean validCandidate(LinkedList<String> candidates) {
        return candidates.stream().allMatch(s ->
                (s.length() > 0 && s.length() <= 3) &&
                (!s.startsWith("0") || s.equals("0")) &&
                Integer.parseInt(s) <= 255);
    }
}
