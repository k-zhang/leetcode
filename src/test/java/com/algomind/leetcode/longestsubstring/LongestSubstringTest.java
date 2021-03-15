package com.algomind.leetcode.longestsubstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestSubstringTest {
    private LongestSubstring longestSubstring = new LongestSubstring();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testLongestSubstring(int result, String s) {
        Assertions.assertEquals(result, longestSubstring.lengthOfLongestSubstring(s));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, ""),
                Arguments.of(1, "a"),
                Arguments.of(3, "abcabcbb"),
                Arguments.of(1, "bbbbb"),
                Arguments.of(3, "pwwkew"),
                Arguments.of(2, "abbbbbba")
        );
    }
}