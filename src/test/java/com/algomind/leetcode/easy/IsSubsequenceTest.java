package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IsSubsequenceTest {
    private final IsSubsequence isSubsequence = new IsSubsequence();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testIsSubsequence(boolean expected, String s, String t) {
        Assertions.assertEquals(expected, isSubsequence.isSubsequence(s, t));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, "abc", "ahbgdc"),
                Arguments.of(false, "axc", "ahbgdc"),
                Arguments.of(true, "", ""),
                Arguments.of(true, "", "a")
        );
    }
}