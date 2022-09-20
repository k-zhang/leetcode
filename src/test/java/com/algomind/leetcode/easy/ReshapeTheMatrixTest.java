package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReshapeTheMatrixTest {
    private final ReshapeTheMatrix solution = new ReshapeTheMatrix();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int[][] mat, int r, int c) {
        int[][] result = solution.matrixReshape(mat, r, c);

        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2,3,4}}, new int[][]{{1,2},{3,4}}, 1, 4),
                Arguments.of(new int[][]{{1,2},{3,4}}, new int[][]{{1,2},{3,4}}, 2, 4),
                Arguments.of(new int[][]{{1,2},{3,4},{5,6},{7,8}}, new int[][]{{1,2,3,4},{5,6,7,8}}, 4, 2),
                Arguments.of(new int[][]{{1},{2},{3},{4},{5},{6},{7},{8}}, new int[][]{{1,2,3,4},{5,6,7,8}}, 8, 1),
                Arguments.of(new int[][]{{1}}, new int[][]{{1}}, 1, 1)
        );
    }
}