package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PlusOneTest {
    private final PlusOne solution = new PlusOne();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] input) {
        Assertions.assertArrayEquals(expected, solution.plusOne(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{0}),
                Arguments.of(new int[]{1,2,4}, new int[]{1,2,3}),
                Arguments.of(new int[]{4,3,2,2}, new int[]{4,3,2,1}),
                Arguments.of(new int[]{4,3,3,0}, new int[]{4,3,2,9}),
                Arguments.of(new int[]{4,4,0,0}, new int[]{4,3,9,9}),
                Arguments.of(new int[]{5,0,0,0}, new int[]{4,9,9,9}),
                Arguments.of(new int[]{1,0,0,0,0}, new int[]{9,9,9,9})
               );
    }
}