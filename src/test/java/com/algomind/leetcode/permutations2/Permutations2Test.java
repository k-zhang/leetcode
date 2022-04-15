package com.algomind.leetcode.permutations2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Permutations2Test {
    private final Permutations2 solution = new Permutations2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<List<Integer>> expected, int[] input) {
        var result = solution.permuteUnique(input);
        Assertions.assertEquals(expected, new HashSet<>(result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(Set.of(List.of(1,1,2), List.of(1,2,1), List.of(2,1,1)), new int[]{1,1,2}),
                Arguments.of(Set.of(List.of(1,2,3), List.of(1,3,2), List.of(2,1,3),
                        List.of(2,3,1), List.of(3,1,2), List.of(3,2,1)), new int[]{1,2,3}));
    }
}