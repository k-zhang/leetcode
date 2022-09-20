package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ZeroOneMatrixTest {
    private final ZeroOneMatrix solution = new ZeroOneMatrix();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int[][] mat) {
        Assertions.assertArrayEquals(expected, solution.updateMatrix(mat));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, new int[][]{{0,0,0},{0,1,0},{0,0,0}}),
                Arguments.of(new int[][]{{0,0,0},{0,1,0},{1,2,1}}, new int[][]{{0,0,0},{0,1,0},{1,1,1}}),
                Arguments.of(new int[][]{{2,1,2},{1,0,1},{2,1,2}}, new int[][]{{1,1,1},{1,0,1},{1,1,1}})
        );
    }
}