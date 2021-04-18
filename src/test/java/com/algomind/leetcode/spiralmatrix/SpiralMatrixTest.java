package com.algomind.leetcode.spiralmatrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SpiralMatrixTest {
    private final SpiralMatrix spiralMatrix = new SpiralMatrix();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(List<Integer> expected, int[][] matrix) {
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        List.of(1),
                        new int[][]{new int[]{1}}),
                Arguments.of(
                        List.of(1,2),
                        new int[][]{new int[]{1,2}}),
                Arguments.of(
                        List.of(1,2,3,4),
                        new int[][]{new int[]{1,2,3,4}}),
                Arguments.of(
                        List.of(1,2,3,4,5),
                        new int[][]{new int[]{1},new int[]{2},new int[]{3},new int[]{4},new int[]{5}}),
                Arguments.of(
                        List.of(1,2,3,4,8,12,11,10,9,5,6,7),
                        new int[][]{new int[]{1,2,3,4},new int[]{5,6,7,8},new int[]{9,10,11,12}}),
                Arguments.of(
                        List.of(1,2,3,4,8,7,6,5),
                        new int[][]{new int[]{1,2,3,4},new int[]{5,6,7,8}}),
                Arguments.of(
                        List.of(1,2,4,6,8,7,5,3),
                        new int[][]{new int[]{1,2},new int[]{3,4},new int[]{5,6},new int[]{7,8}}),
                Arguments.of(
                        List.of(1,2,3,6,9,12,11,10,7,4,5,8),
                        new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9},new int[]{10,11,12}})
        );
    }
}