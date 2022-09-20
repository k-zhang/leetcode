package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FirstMissingPositiveTest {
    private final FirstMissingPositive solution = new FirstMissingPositive();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, solution.firstMissingPositive(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, new int[]{1,2,0}),
                Arguments.of(2, new int[]{3,4,-1,1}),
                Arguments.of(1, new int[]{7,8,9,11,12}),
                Arguments.of(1, new int[]{-7,-8,-9,-11,-12}),
                Arguments.of(1, new int[]{0,0}),
                Arguments.of(1, new int[]{10})
        );
    }
}