package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveAllAdjacentDuplicatesInStringTest {
    private final RemoveAllAdjacentDuplicatesInString solution = new RemoveAllAdjacentDuplicatesInString();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String string) {
        Assertions.assertEquals(expected, solution.removeDuplicates2(string));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("ca", "abbaca"),
                Arguments.of("ay", "azxxzy"),
                Arguments.of("", "aa"),
                Arguments.of("", "bcaacb"),
                Arguments.of("c", "aac")
        );
    }
}