package com.algomind.leetcode.maxareaofisland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxAreaOfIslandTest {
    private final MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] grid){
        Assertions.assertEquals(expected, maxAreaOfIsland.maxAreaOfIsland(grid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(6, new int[][]{
                        {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                }),
                Arguments.of(0, new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0}}),
                Arguments.of(1, new int[][]{{0,0,0,0,0,0,0,0,1,0,0,0,0}}),
                Arguments.of(5, new int[][]{{0,0,0,0,0,0,0,0,1,1,1,1,1}}),
                Arguments.of(4, new int[][]{{0},{1},{1},{0},{0},{0},{0},{0},{1},{1},{1},{1},{0}})
        );
    }
}