package com.algomind.leetcode.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        var result = new ArrayList<List<Integer>>();
        result.add(List.of(1));

        List<Integer> lastRow = null;
        for(int i = 1 ; i < numRows ; i ++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1 ; j < i ; j ++) {
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }

            row.add(1);
            result.add(row);
            lastRow = row;
        }

        return result;
    }
}
