package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RangeSumQueryMutable2Test {
    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Integer[] expected, int[] nums, String[] actions, int[][] parameters) {
        var numArray = new RangeSumQueryMutable2(nums);

        Integer[] results = new Integer[actions.length];
        for(int i = 0 ; i < actions.length ; i ++) {
            switch(actions[i]) {
                case "update":
                    numArray.update(parameters[i][0], parameters[i][1]);
                    results[i] = null;
                    break;
                case "sumRange":
                    results[i] = numArray.sumRange(parameters[i][0], parameters[i][1]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        Assertions.assertArrayEquals(expected, results);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new Integer[]{9,null,8}, new int[]{1,3,5}, new String[]{"sumRange","update","sumRange"}, new int[][]{{0,2},{1,2},{0,2}}),
                Arguments.of(new Integer[]{1,null,100}, new int[]{1}, new String[]{"sumRange","update","sumRange"}, new int[][]{{0,0},{0,100},{0,0}}),
                Arguments.of(new Integer[]{12,14,15,15,null,6,14}, new int[]{-2,-1,0,1,2,3,4,5}, new String[]{"sumRange","sumRange","sumRange","sumRange","update","sumRange","sumRange"}, new int[][]{{0,7},{1,7},{2,7},{3,7},{1,1},{3,5},{0,7}}),
                Arguments.of(new Integer[]{6,10,15,21,28,36}, new int[]{1,2,3,4,5,6,7,8}, new String[]{"sumRange","sumRange","sumRange","sumRange","sumRange","sumRange"}, new int[][]{{0,2},{0,3},{0,4},{0,5},{0,6},{0,7}}),
                Arguments.of(new Integer[]{6,10,15,null,117,124,132}, new int[]{1,2,3,4,5,6,7,8}, new String[]{"sumRange","sumRange","sumRange","update","sumRange","sumRange","sumRange"}, new int[][]{{0,2},{0,3},{0,4},{3,100},{0,5},{0,6},{0,7}}),
                Arguments.of(new Integer[]{-1,null,1}, new int[]{-1}, new String[]{"sumRange","update","sumRange"}, new int[][]{{0,0},{0,1},{0,0}}),
                Arguments.of(new Integer[]{null,-8,-5,null,0}, new int[]{9,-8}, new String[]{"update","sumRange","sumRange","update","sumRange"}, new int[][]{{0,3},{1,1},{0,1},{1,-3},{0,1}}),
                Arguments.of(new Integer[]{3,15,7,null,null,null,12,null,5,null}, new int[]{0,9,5,7,3}, new String[]{"sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"},
                        new int[][]{{4,4},{2,4},{3,3},{4,5},{1,7},{0,8},{1,2},{1,9},{4,4},{3,4}})
        );
    }
}