package com.algomind.leetcode.longestpalindromicsubstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String s) {
        Assertions.assertEquals(expected, longestPalindromicSubstring.longestPalindrome(s));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("", null),
                Arguments.of("", ""),
                Arguments.of("aba", "babad"),
                Arguments.of("bb", "cbbd")
        );
    }
}