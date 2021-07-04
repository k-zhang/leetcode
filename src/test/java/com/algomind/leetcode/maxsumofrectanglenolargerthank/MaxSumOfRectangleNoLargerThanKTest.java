package com.algomind.leetcode.maxsumofrectanglenolargerthank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxSumOfRectangleNoLargerThanKTest {
    private final MaxSumOfRectangleNoLargerThanK solution = new MaxSumOfRectangleNoLargerThanK();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMedianOfTwoSortedArrays(double expected, int[][] matrix, int k) {
        Assertions.assertEquals(expected, solution.maxSumSubmatrix(matrix, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1,0,1},{0,-2,3}}, 2),
                Arguments.of(3, new int[][]{{2,2,-1}}, 3)
        );
    }
}