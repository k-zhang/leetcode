package com.algomind.leetcode.hard;

import java.util.*;

public class FindMedianFromDataStream {
    static class FindMedianFromDataStreamAnswer1 {
        private List<Integer> list;

        public FindMedianFromDataStreamAnswer1() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            if(list.isEmpty()) {
                list.add(num);
            }else{
                var insert = Collections.binarySearch(list, num);
                if(insert < 0) {
                    insert = -1 * (insert + 1);
                }
                list.add(insert, num);
            }
        }

        public double findMedian() {
            return list.size() % 2 != 0 ? list.get(list.size() / 2) : (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2d;
        }
    }

    static class FindMedianFromDataStreamAnswer2 {
        private final PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
        private final PriorityQueue<Integer> hi = new PriorityQueue<>();

        public FindMedianFromDataStreamAnswer2() {
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
}
