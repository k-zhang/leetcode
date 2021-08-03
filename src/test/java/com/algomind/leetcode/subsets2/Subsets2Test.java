package com.algomind.leetcode.subsets2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class Subsets2Test {
    private final Subsets2 solution = new Subsets2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<int[]> expected, int[] nums) {
        var result = solution.subsetsWithDup2(nums);

        Assertions.assertEquals(expected.size(), result.size());

        var transformedResult = new HashSet<Subsets2.ResultEntry>();
        for(var entry : result) {
            transformedResult.add(new Subsets2.ResultEntry(entry.stream().mapToInt(i -> i).toArray()));
        }

        var transformedExpected = new HashSet<Subsets2.ResultEntry>();
        for(var entry : expected) {
            transformedExpected.add(new Subsets2.ResultEntry(entry));
        }

        for (var resultElement : transformedResult) {
            Assertions.assertTrue(transformedExpected.contains(resultElement));
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(Set.of(new int[]{}, new int[]{1}, new int[]{1,2}, new int[]{1,2,2}, new int[]{2}, new int[]{2,2}), new int[]{1,2,2}),
                Arguments.of(Set.of(new int[]{}, new int[]{0}), new int[]{0}),
                Arguments.of(Set.of(new int[]{}, new int[]{1}, new int[]{1,1}), new int[]{1,1}),
                Arguments.of(Set.of(new int[]{}, new int[]{1}, new int[]{1,4}, new int[]{1,4,4}, new int[]{1,4,4,4}, new int[]{1,4,4,4,4}, new int[]{4}, new int[]{4,4}, new int[]{4,4,4}, new int[]{4,4,4,4}), new int[]{4,4,4,1,4})
        );
    }
}