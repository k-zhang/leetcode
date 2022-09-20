package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringToIntegerTest {
    private final StringToInteger stringToInteger = new StringToInteger();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testStringToInteger(int expected, String s) {
        Assertions.assertEquals(expected, stringToInteger.myAtoi(s));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(42, "42"),
                Arguments.of(-42, "-42"),
                Arguments.of(4193, "4193 with words"),
                Arguments.of(0, "words and 987"),
                Arguments.of(-2147483648, "-91283472332"),
                Arguments.of(-2147483648, "-2147483648"),
                Arguments.of(2147483647, "91283472332"),
                Arguments.of(2147483647, "2147483647"),
                Arguments.of(45, "0045"),
                Arguments.of(12345678, "  0000000000012345678"),
                Arguments.of(0, "-"),
                Arguments.of(123, "123.1234"),
                Arguments.of(123, "   123A1234   "),
                Arguments.of(123, "+123"),
                Arguments.of(123, "    +123"),
                Arguments.of(0, ""),
                Arguments.of(0, "   "),
                Arguments.of(0, " abc  "),
                Arguments.of(0, "0"),
                Arguments.of(0, "+0"),
                Arguments.of(0, "-0")
        );
    }
}