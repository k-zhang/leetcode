package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IsomorphicStringsTest {
    private final IsomorphicStrings solution = new IsomorphicStrings();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, String s, String t) {
        Assertions.assertEquals(expected, solution.isIsomorphic(s, t));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, "egg", "add"),
                Arguments.of(false, "foo", "bar"),
                Arguments.of(true, "paper", "title"),
                Arguments.of(true, "c", "a"),
                Arguments.of(false, "badc", "baba")
        );
    }
}