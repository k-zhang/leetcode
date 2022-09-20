package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxConsecutiveOnes3Test {
    private final MaxConsecutiveOnes3 solution = new MaxConsecutiveOnes3();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums, int k) {
        Assertions.assertEquals(expected, solution.longestOnes(nums, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(6, new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2),
            Arguments.of(10, new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3),
            Arguments.of(1, new int[]{1}, 0),
            Arguments.of(0, new int[]{0}, 0),
            Arguments.of(1, new int[]{0}, 1),
            Arguments.of(2, new int[]{1,0,0,1}, 1)
        );
    }
}