package com.algomind.leetcode.besttimetobuysellstock2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuySellStock2Test {
    private final BestTimeToBuySellStock2 bestTimeToBuySellStock2 = new BestTimeToBuySellStock2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testBestTimeToBuySellStock2(int expected, int[] input) {
        Assertions.assertEquals(expected, bestTimeToBuySellStock2.maxProfit(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(7, new int[]{7,1,5,3,6,4}),
                Arguments.of(4, new int[]{1,2,3,4,5}),
                Arguments.of(0, new int[]{7,6,4,3,1}),
                Arguments.of(99, new int[]{1,2,3,100}),
                Arguments.of(100, new int[]{1,2,1,100}),
                Arguments.of(0, new int[]{10}),
                Arguments.of(0, new int[]{10,10}),
                Arguments.of(1, new int[]{10,11}),
                Arguments.of(1, new int[]{10,11,10,10}),
                Arguments.of(2, new int[]{0,1,0,1}),
                Arguments.of(1, new int[]{1,0,1,0}),
                Arguments.of(100, new int[]{100,1,101}),
                Arguments.of(1, new int[]{100,1,2})
        );
    }
}