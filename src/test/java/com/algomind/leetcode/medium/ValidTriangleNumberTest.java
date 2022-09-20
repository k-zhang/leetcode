package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidTriangleNumberTest {
    private final ValidTriangleNumber solution = new ValidTriangleNumber();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums) {
        Assertions.assertEquals(expected, solution.triangleNumber1(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new int[]{2,2,3,4}),
            Arguments.of(4, new int[]{4,2,3,4}),
            Arguments.of(0, new int[]{4}),
            Arguments.of(0, new int[]{4,2}),
            Arguments.of(1, new int[]{4,2,3}),
            Arguments.of(0, new int[]{4,5,0}),
            Arguments.of(0, new int[]{0,1,0,1})
        );
    }
}