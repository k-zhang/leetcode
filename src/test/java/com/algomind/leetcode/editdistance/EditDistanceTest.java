package com.algomind.leetcode.editdistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EditDistanceTest {
    private final EditDistance solution = new EditDistance();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, String word1, String word2) {
        Assertions.assertEquals(expected, solution.minDistance(word1, word2));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, "horse", "ros"),
                Arguments.of(1, "a", "b"),
                Arguments.of(1, "ab", "b"),
                Arguments.of(1, "", "b"),
                Arguments.of(1, "a", ""),
                Arguments.of(0, "", ""),
                Arguments.of(0, "abc", "abc")
        );
    }
}