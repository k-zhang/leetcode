package com.algomind.leetcode.searcha2dmatrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchA2DMatrixTest {
    private final SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int[][] matrix, int target) {
        Assertions.assertEquals(expected, searchA2DMatrix.searchMatrix(matrix, target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3),
                Arguments.of(false, new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13),
                Arguments.of(true, new int[][]{{1}}, 1),
                Arguments.of(false, new int[][]{{1}}, 2),
                Arguments.of(true, new int[][]{{1,2},{3,4}}, 2)
        );
    }
}