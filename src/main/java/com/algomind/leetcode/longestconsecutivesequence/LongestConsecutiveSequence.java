package com.algomind.leetcode.longestconsecutivesequence;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
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
