package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromicSubstringTest {
    private final LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testLongestPalindromicSubstring(String expected, String s) {
        Assertions.assertEquals(expected, longestPalindromicSubstring.longestPalindrome(s));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testLongestPalindromicSubstringDP(String expected, String s) {
        Assertions.assertEquals(expected, longestPalindromicSubstring.longestPalindromeDP(s));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("bb", "cbbd"),
                Arguments.of("a", "ac"),
                Arguments.of("e", "eabcd"),
                Arguments.of("aca", "aacabdkacaa")
        );
    }
}