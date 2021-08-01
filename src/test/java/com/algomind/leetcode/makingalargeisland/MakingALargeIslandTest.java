package com.algomind.leetcode.makingalargeisland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MakingALargeIslandTest {
    private final MakingALargeIsland solution = new MakingALargeIsland();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] grid) {
        Assertions.assertEquals(expected, solution.largestIsland(grid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new int[][]{{1,0},{0,1}}),
            Arguments.of(4, new int[][]{{1,1},{1,0}}),
            Arguments.of(4, new int[][]{{1,1},{1,1}}),
            Arguments.of(1, new int[][]{{0,0},{0,0}}),
            Arguments.of(2, new int[][]{{1,0},{0,0}}),
            Arguments.of(2, new int[][]{{1,0,0},{0,0,0},{0,0,1}})
        );
    }
}