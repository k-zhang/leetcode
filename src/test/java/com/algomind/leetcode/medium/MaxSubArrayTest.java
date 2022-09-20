package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxSubArrayTest {
    private final MaxSubArray maxSubArray = new MaxSubArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMaxSubArray(int expected, int[] input) {
        Assertions.assertEquals(expected, maxSubArray.maxSubArray(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(6, new int[]{-2,1,-3,4,-1,2,1,-5,4}),
                Arguments.of(1, new int[]{1}),
                Arguments.of(23, new int[]{5,4,-1,7,8})
        );
    }
}