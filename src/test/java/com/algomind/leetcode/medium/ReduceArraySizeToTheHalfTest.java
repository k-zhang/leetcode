package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReduceArraySizeToTheHalfTest {
    private final ReduceArraySizeToTheHalf solution = new ReduceArraySizeToTheHalf();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, solution.minSetSize(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, new int[]{3,3,3,3,5,5,5,2,2,7}),
            Arguments.of(1, new int[]{7,7,7,7,7,7}),
            Arguments.of(1, new int[]{1,9}),
            Arguments.of(1, new int[]{1000,1000,3,7}),
            Arguments.of(5, new int[]{1,2,3,4,5,6,7,8,9,10}),
            Arguments.of(1, new int[]{5,6})
        );
    }
}