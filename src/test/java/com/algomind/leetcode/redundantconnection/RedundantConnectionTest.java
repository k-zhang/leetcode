package com.algomind.leetcode.redundantconnection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RedundantConnectionTest {
    private final RedundantConnection solution = new RedundantConnection();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[][] edges) {
        Assertions.assertArrayEquals(expected, solution.findRedundantConnection(edges));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{2,3}, new int[][]{{1,2},{1,3},{2,3}}),
            Arguments.of(new int[]{1,4}, new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}}),
            Arguments.of(new int[]{4,5}, new int[][]{{1,2},{2,3},{3,4},{1,5},{4,5}}),
            Arguments.of(new int[]{2,5}, new int[][]{{1,2},{2,3},{3,4},{1,5},{2,5}}),
            Arguments.of(new int[]{3,5}, new int[][]{{1,3},{3,4},{1,5},{3,5},{2,3}}),
            Arguments.of(new int[]{4,10}, new int[][]{{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}}),
            Arguments.of(new int[]{3,5}, new int[][]{{1,5},{2,4},{3,4},{1,3},{3,5}})
        );
    }
}