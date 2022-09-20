package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidParenthesesTest {
    private final ValidParentheses validParentheses = new ValidParentheses();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, String string) {
        Assertions.assertEquals(expected, validParentheses.isValid(string));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, ""),
                Arguments.of(true, "(){}[]"),
                Arguments.of(true, "()"),
                Arguments.of(true, "{}"),
                Arguments.of(true, "[]"),
                Arguments.of(false, "({(}[]"),
                Arguments.of(false, "]["),
                Arguments.of(true, "{([[]])}"),
                Arguments.of(true, "({}{}{[][]}{}[(([]))])"),
                Arguments.of(false, "({}{}{[][]}{]}[(([]))])")
        );
    }
}