package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class SubsetsTest {
    private final Subsets subsets = new Subsets();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<Set<Integer>> expected, int[] nums) {
        var result = subsets.subsets1(nums);

        Assertions.assertEquals(expected.size(), result.size());

        for (List<Integer> resultElement : result) {
            Set<Integer> resultElementSet = new HashSet<>(resultElement);
            Assertions.assertTrue(expected.contains(resultElementSet));
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(Set.of(Set.of(), Set.of(1),Set.of(2),Set.of(1,2),Set.of(3),Set.of(1,3),Set.of(2,3),Set.of(1,2,3)), new int[]{1,2,3}),
                Arguments.of(Set.of(Set.of(), Set.of(1),Set.of(2),Set.of(1,2)), new int[]{1,2}),
                Arguments.of(Set.of(Set.of(), Set.of(0)), new int[]{0}),
                Arguments.of(Set.of(Set.of(), Set.of(1),Set.of(2),Set.of(1,2),Set.of(3),Set.of(1,3),Set.of(2,3),Set.of(1,2,3),
                                              Set.of(4),Set.of(1,4),Set.of(2,4),Set.of(1,2,4),Set.of(3,4),Set.of(1,3,4),Set.of(2,3,4),Set.of(1,2,3,4)), new int[]{1,2,3,4})
        );
    }
}