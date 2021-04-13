package com.algomind.leetcode.uniquebinarysearchtrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniqueBinarySearchTreesTest {
    private final UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int input) {
        Assertions.assertEquals(expected, uniqueBinarySearchTrees.numTrees(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(5, 3),
                Arguments.of(14, 4),
                Arguments.of(42, 5),
                Arguments.of(1767263190, 19)
        );
    }
}