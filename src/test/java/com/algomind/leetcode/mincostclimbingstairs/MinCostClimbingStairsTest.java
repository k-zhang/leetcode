package com.algomind.leetcode.mincostclimbingstairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinCostClimbingStairsTest {
    private final MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testBestTimeToBuySellStock1(int expected, int[] input) {
        Assertions.assertEquals(expected, minCostClimbingStairs.minCostClimbingStairs(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(15, new int[]{10, 15, 20}),
                Arguments.of(6, new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}),
                Arguments.of(1, new int[]{1,2}),
                Arguments.of(0, new int[]{0,0,0,0}),
                Arguments.of(0, new int[]{0,0,0,1})
        );
    }
}