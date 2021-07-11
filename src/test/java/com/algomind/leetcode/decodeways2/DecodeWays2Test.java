package com.algomind.leetcode.decodeways2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DecodeWays2Test {
    private final DecodeWays2 solution = new DecodeWays2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, String s) {
        Assertions.assertEquals(expected, solution.numDecodings1(s));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, "11106"),
            Arguments.of(9, "*"),
            Arguments.of(18, "1*"),
            Arguments.of(15, "2*"),
            Arguments.of(8, "11116"),
            Arguments.of(96, "**"),
            Arguments.of(11, "*1"),
            Arguments.of(0, "0")
        );
    }
}