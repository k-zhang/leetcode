package com.algomind.leetcode.spiralmatrix2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SpiralMatrix2Test {
    private final SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int n) {
        Assertions.assertArrayEquals(expected, spiralMatrix2.generateMatrix1(n));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2,3},{8,9,4},{7,6,5}}, 3),
                Arguments.of(new int[][]{{1}}, 1),
                Arguments.of(new int[][]{{1,2},{4,3}}, 2),
                Arguments.of(new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}}, 4)
        );
    }
}