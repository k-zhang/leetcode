package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ImplementStrStrTest {
    private final ImplementStrStr implementStrStr = new ImplementStrStr();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, String hayStack, String needle) {
        var result = implementStrStr.strStr2(hayStack, needle);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, "hello", "ll"),
            Arguments.of(-1, "aaaaa", "bba"),
            Arguments.of(1, "cabcabcd", "abc"),
            Arguments.of(0, "abcabcd", "abc"),
            Arguments.of(-1, "aaa", "aaaa"),
            Arguments.of(0, "aaa", "aaa"),
            Arguments.of(4, "mississippi", "issip"),
            Arguments.of(-1, "mississippi", "issipi"),
            Arguments.of(11, "aabcdeafghiajtjtjklmf", "ajtj"),
            Arguments.of(0, "", "")
        );
    }
}