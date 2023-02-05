package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class CombinationsTest {
    private final Combinations combinations = new Combinations();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<List<Integer>> expected, int n, int k) {
        var result = combinations.combine(n, k);
        Assertions.assertEquals(expected, new HashSet<>(result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(Set.of(List.of(1,2), List.of(1,3), List.of(1,4), List.of(2,3), List.of(2,4), List.of(3,4)), 4, 2),
                Arguments.of(Set.of(List.of(1)), 1, 1),
                Arguments.of(Set.of(List.of(1,2,3), List.of(1,2,4), List.of(1,3,4), List.of(2,3,4)), 4, 3)
        );
    }
}