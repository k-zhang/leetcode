package com.algomind.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadEnd = Arrays.stream(deadends).collect(Collectors.toSet());

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet<>();
        seen.add("0000");

        int steps = 0;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s == null) {
                steps++;
                if (queue.peek() != null) queue.offer(null);
            } else if (s.equals(target)) {
                return steps;
            } else if(!deadEnd.contains(s)) {
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d += 2) {
                        int newChar = ((s.charAt(i) - '0') + d + 10) % 10;
                        String newNumber = s.substring(0, i) + ("" + newChar) + s.substring(i + 1);
                        if (!seen.contains(newNumber)) {
                            queue.offer(newNumber);
                            seen.add(newNumber);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
