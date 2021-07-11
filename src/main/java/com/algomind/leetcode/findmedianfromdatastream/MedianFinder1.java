package com.algomind.leetcode.findmedianfromdatastream;

import java.util.Comparator;
import java.util.PriorityQueue;

// Use two heaps to dynamically track the median value of a stream
public class MedianFinder1 {
    private final PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> hi = new PriorityQueue<>();

    public MedianFinder1() {
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());

        if(hi.size() > lo.size()) {
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek())  / 2d;
    }
}
