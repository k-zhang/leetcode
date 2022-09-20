package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StoneGame7Test {
    private final StoneGame7 stoneGame7 = new StoneGame7();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, stoneGame7.stoneGameVII(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(6, new int[]{5,3,1,4,2}),
                Arguments.of(122, new int[]{7,90,5,1,100,10,10,2})
        );
    }
}