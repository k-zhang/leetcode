package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindMedianFromDataStreamTest {
    @ParameterizedTest
    @MethodSource("provideData")
    public void testAnswer1(Double[] expected, int[] nums, String[] actions) {
        var medianFinder = new FindMedianFromDataStream.FindMedianFromDataStreamAnswer1();

        Double[] results = new Double[actions.length];
        for(int i = 0 ; i < actions.length ; i ++) {
            switch (actions[i]) {
                case "addNum" -> {
                    medianFinder.addNum(nums[i]);
                    results[i] = null;
                }
                case "findMedian" -> {
                    var median = medianFinder.findMedian();
                    results[i] = median;
                }
                default -> throw new IllegalArgumentException();
            }
        }

        Assertions.assertArrayEquals(expected, results);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new Double[]{null,null,1.5,null,2.0}, new int[]{1,2,-1,3,-1}, new String[]{"addNum", "addNum", "findMedian", "addNum", "findMedian"}),
                Arguments.of(new Double[]{null,1.0}, new int[]{1,-1}, new String[]{"addNum", "findMedian"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testAnswer2(Double[] expected, int[] nums, String[] actions) {
        var medianFinder1 = new FindMedianFromDataStream.FindMedianFromDataStreamAnswer2();

        Double[] results = new Double[actions.length];
        for(int i = 0 ; i < actions.length ; i ++) {
            switch (actions[i]) {
                case "addNum" -> {
                    medianFinder1.addNum(nums[i]);
                    results[i] = null;
                }
                case "findMedian" -> {
                    var median = medianFinder1.findMedian();
                    results[i] = median;
                }
                default -> throw new IllegalArgumentException();
            }
        }

        Assertions.assertArrayEquals(expected, results);
    }
}