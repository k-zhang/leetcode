package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AllPathsFromSourceLeadToDestinationTest {
    private final AllPathsFromSourceLeadToDestination solution = new AllPathsFromSourceLeadToDestination();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int n, int[][] edges, int source, int destination) {
        Assertions.assertEquals(expected, solution.leadsToDestination(n, edges, source, destination));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(true, 1, new int[][]{}, 0, 0),
            Arguments.of(false, 1, new int[][]{{0,0}}, 0, 0),
            Arguments.of(true, 2, new int[][]{{0,1}}, 0, 1),
            Arguments.of(false, 2, new int[][]{{0,0},{0,1}}, 0, 1),
            Arguments.of(false, 3, new int[][]{{0,1},{0,2}}, 0, 2),
            Arguments.of(false, 4, new int[][]{{0,1},{0,3},{1,2},{2,1}}, 0, 3),
            Arguments.of(true, 4, new int[][]{{0,1},{0,2},{1,3},{2,3}}, 0, 3),
            Arguments.of(false, 3, new int[][]{{0,1},{1,1},{1,2}}, 0, 2),
            Arguments.of(false, 2, new int[][]{{0,1},{1,1}}, 0, 1),
            Arguments.of(true, 5, new int[][]{{0,1},{0,2},{0,3},{1,4},{2,4},{3,4}}, 0, 4),
            Arguments.of(false, 5, new int[][]{{0,1},{0,2},{0,3},{1,4},{2,2},{2,4},{3,4}}, 0, 4),
            Arguments.of(true, 5, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,4},{2,4},{3,4}}, 0, 4),
            Arguments.of(true, 6, new int[][]{{0,1},{0,2},{0,3},{1,4},{2,4},{3,4},{4,5}}, 0, 5),
            Arguments.of(false, 6, new int[][]{{0,1},{0,2},{0,3},{1,4},{1,5},{2,1},{4,2},{3,4},{4,5}}, 0, 5),
            Arguments.of(false, 6, new int[][]{{0,1},{0,2},{0,3},{1,4},{1,5},{2,1},{4,2},{3,4}}, 0, 5)
        );
    }

    static class CountSquareSubmatricesWithAllOnesTest {
        private final CountSquareSubmatricesWithAllOnes countSquareSubmatricesWithAllOnes = new CountSquareSubmatricesWithAllOnes();

        @ParameterizedTest
        @MethodSource("provideData")
        public void test(int expected, int[][] mat) {
            Assertions.assertEquals(expected, countSquareSubmatricesWithAllOnes.countSquares(mat));
        }

        private static Stream<Arguments> provideData() {
            return Stream.of(
                Arguments.of(15, new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}),
                Arguments.of(7, new int[][]{{1,0,1},{1,1,0},{1,1,0}})
            );
        }
    }
}