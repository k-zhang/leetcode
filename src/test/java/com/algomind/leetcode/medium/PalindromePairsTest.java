package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class PalindromePairsTest {
    private final PalindromePairs palindromePairs = new PalindromePairs();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testPartitionArrayForMaximumSum(List<List<Integer>> expected, String[] words) {
        Set<List<Integer>> expectedSet = new HashSet<>(expected);
        Set<List<Integer>> resultSet = new HashSet<>(palindromePairs.palindromePairs(words));
        Assertions.assertEquals(expectedSet, resultSet);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(List.of(List.of(0,1),List.of(1,0),List.of(3,2),List.of(2,4)), new String[]{"abcd","dcba","lls","s","sssll"}),
            Arguments.of(List.of(List.of(0,1),List.of(1,0)), new String[]{"bat","tab","cat"}),
            Arguments.of(List.of(List.of(0,1),List.of(1,0)), new String[]{"a",""})
        );
    }
}