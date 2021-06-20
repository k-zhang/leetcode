package com.algomind.leetcode.swiminrisingwater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SwimInRisingWaterTest {
    private final SwimInRisingWater solution = new SwimInRisingWater();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] grid) {
        Assertions.assertEquals(expected, solution.swimInWater(grid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, new int[][]{{0,2},{1,3}}),
                Arguments.of(16, new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}})
        );
    }
}