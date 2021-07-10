package com.algomind.contest.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSquareSumTriplesTest {
    private final CountSquareSumTriples solution = new CountSquareSumTriples();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int n) {
        Assertions.assertEquals(expected, solution.countTriples(n));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, 5),
                Arguments.of(4, 10)
        );
    }
}