package com.algomind.leetcode.uniquepaths2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniquePaths2Test {
    private final UniquePaths2 uniquePaths2 = new UniquePaths2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] obstacleGrid) {
        Assertions.assertEquals(expected, uniquePaths2.uniquePathsWithObstacles(obstacleGrid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{0,0,0},{0,1,0},{0,0,0}}),
                Arguments.of(1, new int[][]{{0,1},{0,0}}),
                Arguments.of(0, new int[][]{{1,0,0},{0,0,0},{0,0,0}}),
                Arguments.of(0, new int[][]{{0,0,0},{0,0,0},{0,0,1}}),
                Arguments.of(4, new int[][]{{0,0,0,0,0,0,0},{0,0,1,0,0,0,0},{0,1,0,0,0,1,0}})
        );
    }
}