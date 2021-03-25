package com.algomind.leetcode.medianoftwosortedarrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MedianOfTwoSortedArraysTest {
    private final MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMedianOfTwoSortedArrays(double expected, int[] num1, int[] num2) {
        Assertions.assertEquals(expected, medianOfTwoSortedArrays.findMedianSortedArrays(num1, num2));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2.0d, new int[]{1,3}, new int[]{2}),
                Arguments.of(2.0d, new int[]{1,2,3}, new int[]{}),
                Arguments.of(2.5d, new int[]{1,2,3,4}, new int[]{}),
                Arguments.of(2.5d, new int[]{}, new int[]{1,2,3,4}),
                Arguments.of(2.5d, new int[]{1,2}, new int[]{3,4}),
                Arguments.of(0.0d, new int[]{0,0}, new int[]{0,0}),
                Arguments.of(1.0d, new int[]{}, new int[]{1}),
                Arguments.of(2.0d, new int[]{2}, new int[]{}),
                Arguments.of(0.0d, new int[]{}, new int[]{})
        );
    }
}