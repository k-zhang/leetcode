package com.algomind.leetcode.maximumproductoftwoelementsinanarray;

import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInAnArray {
    // Using Heap
    public int maxProduct(int[] nums) {
        var heap = new PriorityQueue<Integer>(2);
        heap.add(nums[0]);
        heap.add(nums[1]);

        for(int i = 2 ; i < nums.length; i ++) {
            if(nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }

        int[] array = heap.stream().mapToInt(i -> i).toArray();
        return (array[0] - 1) * (array[1] - 1);
    }
}
