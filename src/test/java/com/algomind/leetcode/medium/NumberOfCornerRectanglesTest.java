package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfCornerRectanglesTest {
    private final NumberOfCornerRectangles numberOfCornerRectangles = new NumberOfCornerRectangles();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testNumberOfCornerRectangles(int expected, int[][] grid) {
        Assertions.assertEquals(expected, numberOfCornerRectangles.countCornerRectangles(grid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, new int[][]{{1,0,0,1,0},{0,0,1,0,1},{0,0,0,1,0},{1,0,1,0,1}}),
                Arguments.of(0, new int[][]{{1,0,0,1,0},{0,0,1,0,1},{0,0,0,1,0},{1,1,0,0,1}}),
                Arguments.of(1, new int[][]{{0,1,0,1,0},{0,0,1,0,1},{0,1,0,1,0},{1,0,0,0,1}}),
                Arguments.of(12, new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,0},{1,0,0,0}}),
                Arguments.of(9, new int[][]{{1,1,1},{1,1,1},{1,1,1}}),
                Arguments.of(4, new int[][]{{1,0,1},{0,1,1},{1,1,1},{1,0,1}}),
                Arguments.of(0, new int[][]{{1}})
        );
    }
}