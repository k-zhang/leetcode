package com.algomind.leetcode.findmedianfromdatastream;

import java.util.*;

public class MedianFinder {
    private List<Integer> list;

    public MedianFinder() {
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
