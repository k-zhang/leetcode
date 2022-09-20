package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfRefuelingStopsTest {
    private final MinimumNumberOfRefuelingStops minimumNumberOfRefuelingStops = new MinimumNumberOfRefuelingStops();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int target, int startFuel, int[][] stations) {
        Assertions.assertEquals(expected, minimumNumberOfRefuelingStops.minRefuelStops(target, startFuel, stations));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, 100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}),
            Arguments.of(-1, 100, 1, new int[][]{{10,100}}),
            Arguments.of(1, 100, 20, new int[][]{{10,100}, {20, 5},{30, 5},{60, 5}}),
            Arguments.of(-1, 100, 5, new int[][]{{10,100}, {20, 5},{30, 5},{60, 5}}),
            Arguments.of(0, 1, 1, new int[][]{})
        );
    }
}