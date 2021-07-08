package com.algomind.leetcode.reversewordsinastring2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseWordsInAString2Test {
    private final ReverseWordsInAString2 solution = new ReverseWordsInAString2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(char[] expected, char[] s) {
        solution.reverseWords(s);
        Assertions.assertArrayEquals(expected, s);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new char[]{'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'}, new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'}),
            Arguments.of(new char[]{'b','l','u','e',' ','i','s'}, new char[]{'i','s',' ','b','l','u','e'}),
            Arguments.of(new char[]{'b','l','u','e'}, new char[]{'b','l','u','e'}),
            Arguments.of(new char[]{'a'}, new char[]{'a'})
        );
    }
}