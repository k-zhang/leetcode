package com.algomind.leetcode.matrixblocksum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class MatrixBlockSumTest {
    private final MatrixBlockSum matrixBlockSum = new MatrixBlockSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMatrixBlockSum(int[][] expected, int[][] mat, int K) {
        int[][] result = matrixBlockSum.matrixBlockSum(mat, K);
        System.out.println(Arrays.deepToString(result));
        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[][]{{12,21,16},{27,45,33},{24,39,28}}, new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1),
            Arguments.of(new int[][]{{45,45,45},{45,45,45},{45,45,45}}, new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 2),
            Arguments.of(new int[][]{{27,42,60,54,45},{42,64,90,80,66},{42,64,90,80,66},{36,54,75,66,54}}, new int[][]{{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}}, 2),
            Arguments.of(new int[][]{{90,90,90,90,90},{90,90,90,90,90},{90,90,90,90,90},{90,90,90,90,90}}, new int[][]{{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}}, 100),
            Arguments.of(new int[][]{{1}}, new int[][]{{1}}, 1),
            Arguments.of(new int[][]{{6},{10},{15},{14},{12}}, new int[][]{{1},{2},{3},{4},{5}}, 2),
            Arguments.of(new int[][]{{6,10,15,14,12}}, new int[][]{{1,2,3,4,5}}, 2)
        );
    }

    @Test
    public void printAccumulationMatrix() {
        int[][] mc = matrixBlockSum.calculateSumMatrix(new int[][]{{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}});
        System.out.println(Arrays.deepToString(mc));
    }
}