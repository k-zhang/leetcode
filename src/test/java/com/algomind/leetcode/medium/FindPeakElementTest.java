package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindPeakElementTest {
    private final FindPeakElement solution = new FindPeakElement();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, solution.findPeakElement1(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[]{1,2,3,1}),
                Arguments.of(5, new int[]{1,2,1,3,5,6,4}),
                Arguments.of(5, new int[]{1,2,3,4,5,6}),
                Arguments.of(5, new int[]{1,2,3,4,3,6}),
                Arguments.of(2, new int[]{1,2,4,3,2,6}),
                Arguments.of(0, new int[]{1}),
                Arguments.of(1, new int[]{3,4,3,2,1}),
                Arguments.of(0, new int[]{6,4,3,2,1,2}),
                Arguments.of(0, new int[]{-2147483648})
        );
    }
}