package com.algomind.leetcode.minimumpathsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumPathSumTest {
    private final MinimumPathSum minimumPathSum = new MinimumPathSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] grid) {
        Assertions.assertEquals(expected, minimumPathSum.minPathSum1(grid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(7, new int[][]{{1,3,1},{1,5,1},{4,2,1}}),
                Arguments.of(12, new int[][]{{1,2,3},{4,5,6}}),
                Arguments.of(1, new int[][]{{1}}),
                Arguments.of(10, new int[][]{{1,2,3,4}}),
                Arguments.of(10, new int[][]{{1},{2},{3},{4}})
        );
    }
}