package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CandyTest {
    private final Candy candy = new Candy();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, candy.candy(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(5, new int[]{1,0,2}),
            Arguments.of(4, new int[]{1,2,2}),
            Arguments.of(15, new int[]{5,4,3,2,1}),
            Arguments.of(5, new int[]{5,5,5,5,5}),
            Arguments.of(10, new int[]{4,3,5,2,2,3,1}),
            Arguments.of(15, new int[]{1,2,3,4,5}),
            Arguments.of(1, new int[]{5}),
            Arguments.of(16, new int[]{12,4,3,11,34,34,1,67})
        );
    }
}