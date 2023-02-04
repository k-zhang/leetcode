package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GreatestCommonDivisorOfStringsTest {

    private final GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String str1, String str2) {
        var result = greatestCommonDivisorOfStrings.gcdOfStrings2(str1, str2);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("ABC", "ABCABC", "ABC"),
            Arguments.of("ABC", "ABC", "ABCABC"),
            Arguments.of("", "ABCZ", "ABCABC"),
            Arguments.of("", "LEET", "CODE"),
            Arguments.of("AB", "ABABAB", "ABAB"),
            Arguments.of("AB", "ABAB", "ABABAB"),
            Arguments.of("", "A", ""),
            Arguments.of("A", "A", "A"),
            Arguments.of("ABA", "ABAABA", "ABA"),
            Arguments.of("", "ABAABA", "AA")
        );
    }

}