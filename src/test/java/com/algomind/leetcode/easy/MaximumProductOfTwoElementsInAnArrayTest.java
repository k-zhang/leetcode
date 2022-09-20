package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumProductOfTwoElementsInAnArrayTest {
    private final MaximumProductOfTwoElementsInAnArray solution = new MaximumProductOfTwoElementsInAnArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums) {
        Assertions.assertEquals(expected, solution.maxProduct(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(12, new int[]{3,4,5,2}),
            Arguments.of(572, new int[]{3,4,5,2,6,3,5,6,10,4,14,8,19,23,3,1,6,8,11,27}),
            Arguments.of(16, new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}),
            Arguments.of(0, new int[]{1,1}),
            Arguments.of(1, new int[]{2,2})
        );
    }
}