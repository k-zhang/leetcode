package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CustomSortStringTest {
    private final CustomSortString solution = new CustomSortString();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String order, String string) {
        Assertions.assertEquals(expected, solution.customSortString(order, string));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("cbad", "cba", "abcd"),
            Arguments.of("zzzyyyyxxaaabeffggijnq", "zyx", "abfiengjyxyafzyxazyqgz"),
            Arguments.of("a", "zyx", "a"),
            Arguments.of("a", "a", "a"),
            Arguments.of("", "a", ""),
            Arguments.of("cba", "", "cba")
        );
    }
}