package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FibonacciNumberTest {
    private final FibonacciNumber fibonacciNumber = new FibonacciNumber();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testFibonacciNumber1(int expected, int input) {
        Assertions.assertEquals(expected, fibonacciNumber.fib1(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(2, 3),
                Arguments.of(3, 4),
                Arguments.of(5, 5),
                Arguments.of(8, 6),
                Arguments.of(13, 7),
                Arguments.of(21, 8)
        );
    }
}