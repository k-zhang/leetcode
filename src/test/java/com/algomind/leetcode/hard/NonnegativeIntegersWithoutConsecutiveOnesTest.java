package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NonnegativeIntegersWithoutConsecutiveOnesTest {
    private final NonnegativeIntegersWithoutConsecutiveOnes solution = new NonnegativeIntegersWithoutConsecutiveOnes();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int num) {
        Assertions.assertEquals(expected, solution.findIntegers(num));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(5, 5)
        );
    }
}