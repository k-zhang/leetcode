package com.algomind.leetcode.besttimetobuysellstock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuySellStockTest {
    private final BestTimeToBuySellStock bestTimeToBuySellStock = new BestTimeToBuySellStock();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testBestTimeToBuySellStock1(int expected, int[] input) {
        Assertions.assertEquals(expected, bestTimeToBuySellStock.maxProfit(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(5, new int[]{7,1,5,3,6,4}),
                Arguments.of(0, new int[]{7,6,4,3,1}),
                Arguments.of(0, new int[]{1}),
                Arguments.of(0, new int[]{1,1}),
                Arguments.of(1, new int[]{1,0,1})
        );
    }
}