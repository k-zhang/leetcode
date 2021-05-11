package com.algomind.leetcode.setmatrixzeroes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SetMatrixZeroesTest {
    private final SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int[][] matrix) {
        setMatrixZeroes.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,0,1},{0,0,0},{1,0,1}}, new int[][]{{1,1,1},{1,0,1},{1,1,1}}),
                Arguments.of(new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}}, new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}}),
                Arguments.of(new int[][]{{0,0,0},{0,4,3},{0,5,1},{0,0,0}}, new int[][]{{0,3,1},{1,4,3},{2,5,1},{0,2,5}}),
                Arguments.of(new int[][]{{0}}, new int[][]{{0}}),
                Arguments.of(new int[][]{{1}}, new int[][]{{1}}),
                Arguments.of(new int[][]{{0,0},{1,0}}, new int[][]{{1,0},{1,1}}),
                Arguments.of(new int[][]{{1,0},{0,0}}, new int[][]{{1,1},{1,0}})
        );
    }
}