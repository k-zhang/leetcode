package com.algomind.leetcode.climbingstairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ClimbingStairsTest {
    private final ClimbingStairs climbingStairs = new ClimbingStairs();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testClimbingStairs(int expected, int input) {
        Assertions.assertEquals(expected, climbingStairs.climbStairs(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(5, 4)
        );
    }
}