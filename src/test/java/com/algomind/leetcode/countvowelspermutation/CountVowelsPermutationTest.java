package com.algomind.leetcode.countvowelspermutation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountVowelsPermutationTest {
    private final CountVowelsPermutation solution = new CountVowelsPermutation();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCreateBinaryTreeInOrder(int expected, int n) {
        Assertions.assertEquals(expected, solution.countVowelPermutation(n));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(5,1),
            Arguments.of(10,2),
            Arguments.of(68,5),
            Arguments.of(18208803,144)
        );
    }
}