package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class PalindromePartitioningTest {
    private final PalindromePartitioning solution = new PalindromePartitioning();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testPartitionArrayForMaximumSum(Set<List<String>> expected, String s) {
        var result = solution.partition(s);
        var resultSet = new HashSet<>(result);
        Assertions.assertEquals(expected, resultSet);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(Set.of(List.of("a","a","b"),List.of("aa","b")), "aab"),
                Arguments.of(Set.of(List.of("b","a","b","a","d","a"),List.of("bab","a","d","a"),List.of("b","aba","d","a"),List.of("bab","ada"),List.of("b","a","b","ada")), "babada"),
                Arguments.of(Set.of(List.of("a")), "a")
        );
    }
}