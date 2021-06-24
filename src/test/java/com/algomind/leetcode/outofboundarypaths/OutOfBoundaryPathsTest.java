package com.algomind.leetcode.outofboundarypaths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OutOfBoundaryPathsTest {
    private final OutOfBoundaryPaths solution = new OutOfBoundaryPaths();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int m, int n, int maxMove, int startRow, int startColumn){
        Assertions.assertEquals(expected, solution.findPaths(m, n, maxMove, startRow, startColumn));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(0, 1, 1, 0, 0, 0),
            Arguments.of(4, 1, 1, 1, 0, 0),
            Arguments.of(4, 1, 1, 5, 0, 0),
            Arguments.of(6, 2, 2, 2, 0, 0),
            Arguments.of(12, 1, 3, 3, 0, 1),
            Arguments.of(0, 50, 50, 20, 25, 25),
            Arguments.of(914783380, 8, 50, 23, 5, 26)
        );
    }
}