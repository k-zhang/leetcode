package com.algomind.leetcode.countsquaresubmatrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSquareSubmatricesTest {
    private final CountSquareSubmatrices countSquareSubmatrices = new CountSquareSubmatrices();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMatrixBlockSum(int expected, int[][] mat) {
        Assertions.assertEquals(expected, countSquareSubmatrices.countSquares(mat));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(15, new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}),
            Arguments.of(7, new int[][]{{1,0,1},{1,1,0},{1,1,0}})
        );
    }
}