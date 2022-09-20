package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumUnitsOnATruckTest {
    private final MaximumUnitsOnATruck solution = new MaximumUnitsOnATruck();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] boxTypes, int truckSize) {
        Assertions.assertEquals(expected, solution.maximumUnits(boxTypes, truckSize));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(8, new int[][]{{1,3},{2,2},{3,1}}, 4),
                Arguments.of(91, new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10),
                Arguments.of(40, new int[][]{{5,10}}, 4),
                Arguments.of(76, new int[][]{{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}}, 35)
        );
    }
}