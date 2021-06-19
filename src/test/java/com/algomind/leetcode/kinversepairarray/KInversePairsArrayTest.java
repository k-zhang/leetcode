package com.algomind.leetcode.kinversepairarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KInversePairsArrayTest {
    private final KInversePairsArray solution = new KInversePairsArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int n, int k) {
        Assertions.assertEquals(expected, solution.kInversePairs(n, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 3, 0),
                Arguments.of(2, 3, 1)
        );
    }
}