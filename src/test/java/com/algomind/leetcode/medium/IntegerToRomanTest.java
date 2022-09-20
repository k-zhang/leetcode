package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntegerToRomanTest {
    private final IntegerToRoman integerToRoman = new IntegerToRoman();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testIntegerToRoman(String expected, int s) {
        Assertions.assertEquals(expected, integerToRoman.intToRoman(s));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("V", 5),
                Arguments.of("VI", 6),
                Arguments.of("VII", 7),
                Arguments.of("VIII", 8),
                Arguments.of("IX", 9),
                Arguments.of("X", 10),
                Arguments.of("XX", 20),
                Arguments.of("XXX", 30),
                Arguments.of("XL", 40),
                Arguments.of("L", 50),
                Arguments.of("LX", 60),
                Arguments.of("LXX", 70),
                Arguments.of("LXXX", 80),
                Arguments.of("XC", 90),
                Arguments.of("C", 100),
                Arguments.of("CC", 200),
                Arguments.of("CCC", 300),
                Arguments.of("CD", 400),
                Arguments.of("D", 500),
                Arguments.of("DC", 600),
                Arguments.of("DCC", 700),
                Arguments.of("DCCC", 800),
                Arguments.of("CM", 900),
                Arguments.of("M", 1000),
                Arguments.of("XIV", 14),
                Arguments.of("XIX", 19),
                Arguments.of("CXL", 140),
                Arguments.of("CXC", 190),
                Arguments.of("MCD", 1400),
                Arguments.of("MCM", 1900)
        );
    }
}