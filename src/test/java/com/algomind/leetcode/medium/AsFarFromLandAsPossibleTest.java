package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AsFarFromLandAsPossibleTest {
    private final AsFarFromLandAsPossible asFarFromLandAsPossible = new AsFarFromLandAsPossible();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCreateBinaryTreeInOrder(int expected, int[][] grid) {
        var result = asFarFromLandAsPossible.maxDistance(grid);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1,0,1},{0,0,0},{1,0,1}}),
                Arguments.of(4, new int[][]{{1,0,0},{0,0,0},{0,0,0}}),
                Arguments.of(2, new int[][]{{0,0,0},{0,1,0},{0,0,0}}),
                Arguments.of(-1, new int[][]{{0,0,0},{0,0,0},{0,0,0}}),
                Arguments.of(-1, new int[][]{{1,1,1},{1,1,1},{1,1,1}}),
                Arguments.of(-1, new int[][]{{1}}),
                Arguments.of(-1, new int[][]{{0}})
        );
    }
}