package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniquePathsTest {
    private final UniquePaths uniquePaths = new UniquePaths();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int m, int n) {
        Assertions.assertEquals(expected, uniquePaths.uniquePaths(m, n));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(28, 3, 7),
                Arguments.of(3, 3, 2),
                Arguments.of(28, 7, 3),
                Arguments.of(6, 3, 3),
                Arguments.of(50, 50, 2),
                Arguments.of(22100, 50, 4)
        );
    }
}