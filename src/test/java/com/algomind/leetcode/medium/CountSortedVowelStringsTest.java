package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSortedVowelStringsTest {
    private final CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testFibonacciNumber1(int expected, int n) {
        Assertions.assertEquals(expected, countSortedVowelStrings.countSortedVowelStrings(n));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(5, 1),
                Arguments.of(15, 2),
                Arguments.of(35, 3),
                Arguments.of(70, 4),
                Arguments.of(126, 5),
                Arguments.of(210, 6),
                Arguments.of(330, 7),
                Arguments.of(495, 8),
                Arguments.of(66045, 33)
        );
    }
}