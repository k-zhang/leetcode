package com.algomind.leetcode.graycode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        var result = new ArrayList<Integer>();
        int pow = 1 << n;
        for(int i = 0 ; i < pow ; i ++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public List<Integer> grayCode1(int n) {
        var result = new ArrayList<Integer>();
        result.add(0);

        int head = 1;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = result.size() - 1; j >= 0 ; j --) {
                result.add(head + result.get(j));
            }
            head <<= 1;
        }
        return result;
    }
}
