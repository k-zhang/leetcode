package com.algomind.leetcode.kthlargestelementinastream;

import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> heap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>(k);
        for(int i = 0 ; i < k && i < nums.length ; i ++) {
            heap.add(nums[i]);
        }

        for(int i = k; i < nums.length ; i ++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(heap.size() < k) {
            heap.add(val);
        }else {
            int peek = heap.peek();
            if (val > peek) {
                heap.poll();
                heap.add(val);
            }
        }

        return heap.peek();
    }
}
