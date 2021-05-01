package com.algomind.leetcode.numberofconnectedcomponents;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfConnectedComponentsTest {
    private final NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int n, int[][] edges) {
        Assertions.assertEquals(expected, numberOfConnectedComponents.countComponents(n, edges));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, 5, new int[][]{{0,1},{1,2},{3,4}}),
                Arguments.of(1, 5, new int[][]{{0,1},{1,2},{2,3},{3,4}}),
                Arguments.of(1, 5, new int[][]{{0,1},{1,2},{2,4},{3,4}}),
                Arguments.of(2, 5, new int[][]{{0,1},{1,2},{0,2},{3,4}}),
                Arguments.of(4, 5, new int[][]{{0,1}}),
                Arguments.of(9, 10, new int[][]{{0,1}}),
                Arguments.of(5, 5, new int[][]{{0,0}}),
                Arguments.of(1, 1, new int[][]{{0,0}}),
                Arguments.of(1, 1, new int[][]{}),
                Arguments.of(2000, 2000, new int[][]{{0,0},{100,100},{200,200},{400,400}}),
                Arguments.of(1, 6, new int[][]{{0,1},{0,2},{2,5},{3,4},{3,5}})
        );
    }
}