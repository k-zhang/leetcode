package com.algomind.leetcode.interleavingstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InterleavingStringTest {
    private final InterleavingString interleavingString = new InterleavingString();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testIsSubsequence(boolean expected, String s1, String s2, String s3) {
        Assertions.assertEquals(expected, interleavingString.isInterleave(s1, s2, s3));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, "aabcc", "dbbca", "aadbbcbcac"),
                Arguments.of(false, "aabcc", "dbbca", "aadbbbaccc"),
                Arguments.of(false, "aabcc", "dbbca", "aabccdbbcac"),
                Arguments.of(true, "aabcc", "dbbca", "aabccdbbca"),
                Arguments.of(true, "aabcc", "", "aabcc"),
                Arguments.of(true, "", "aabcc", "aabcc"),
                Arguments.of(true, "e", "aabcc", "aabecc"),
                Arguments.of(true, "ee", "aabcc", "aabecce"),
                Arguments.of(false, "a", "b", "a"),
                Arguments.of(true, "aa", "ab", "aaba"),
                Arguments.of(true, "", "", "")
        );
    }
}