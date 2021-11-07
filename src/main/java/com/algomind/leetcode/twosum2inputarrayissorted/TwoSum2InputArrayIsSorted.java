package com.algomind.leetcode.twosum2inputarrayissorted;

import java.util.HashMap;

public class TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        var map = new HashMap<Integer, Integer>();
        int smallest = numbers[0];

        for(int i = 0 ; i < numbers.length ; i ++) {
            int number = numbers[i];
            int required = target - number;
            if(map.containsKey(required)) {
                return new int[]{map.get(required) + 1, i + 1};
            }else{
                if(smallest + number > target) break;
                map.putIfAbsent(number, i);
            }
        }

        return new int[]{-1, -1};
    }
}
