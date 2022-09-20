package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfMatchingSubsequencesTest {
    private final NumberOfMatchingSubsequences solution = new NumberOfMatchingSubsequences();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testNumberOfCornerRectangles(int expected, String s, String[] words) {
        Assertions.assertEquals(expected, solution.numMatchingSubsequences1(s, words));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, "abcde", new String[]{"a","bb","acd","ace"}),
                Arguments.of(2, "dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}),
                Arguments.of(1, "a", new String[]{"a"}),
                Arguments.of(0, "a", new String[]{"b"}),
                Arguments.of(2, "aecbteuc", new String[]{"cec", "ee", "ea"})
        );
    }
}