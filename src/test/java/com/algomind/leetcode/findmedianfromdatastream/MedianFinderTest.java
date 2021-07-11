package com.algomind.leetcode.findmedianfromdatastream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MedianFinderTest {
    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Double[] expected, int[] nums, String[] actions) {
        var medianFinder = new MedianFinder();

        Double[] results = new Double[actions.length];
        for(int i = 0 ; i < actions.length ; i ++) {
            switch(actions[i]) {
                case "addNum":
                    medianFinder.addNum(nums[i]);
                    results[i] = null;
                    break;
                case "findMedian":
                    var median = medianFinder.findMedian();
                    results[i] = median;
                    break;
                default:
                    throw new IllegalArgumentException();
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
}