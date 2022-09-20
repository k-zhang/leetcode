package com.algomind.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    // O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        int result = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int longest = 0;
                int current = num;

                while(set.contains(current++)) {
                    longest++;
                }

                result = Math.max(result, longest);
            }
        }

        return result;
    }

    // O(nLog(n) + n)
    public int longestConsecutive1(int[] nums) {
        if(nums.length == 0) return 0;

        var heap = new PriorityQueue<Integer>();
        Arrays.stream(nums).forEach(heap::add);

        int result = 0;
        int longest = 1;
        int len = heap.size();
        int last = heap.poll();
        for(int i = 1; i < len ; i ++) {
            int num = heap.poll();

            if(num == last) continue;
            else if(num - last == 1) longest ++;
            else{
                result = Math.max(result, longest);
                longest = 1;
            }

            last = num;
        }

        result = Math.max(result, longest);

        return result;
    }
}
