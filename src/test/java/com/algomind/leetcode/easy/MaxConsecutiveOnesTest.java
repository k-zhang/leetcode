package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxConsecutiveOnesTest {
    private final MaxConsecutiveOnes solution = new MaxConsecutiveOnes();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums) {
        Assertions.assertEquals(expected, solution.findMaxConsecutiveOnes(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(4, new int[]{1,1,1,0,0,0,1,1,1,1,0}),
            Arguments.of(4, new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}),
            Arguments.of(1, new int[]{1}),
            Arguments.of(0, new int[]{0}),
            Arguments.of(1, new int[]{1,0,0,1}),
            Arguments.of(4, new int[]{1,1,1,1}),
            Arguments.of(0, new int[]{0,0,0,0})
        );
    }
}