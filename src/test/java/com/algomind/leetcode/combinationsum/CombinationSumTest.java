package com.algomind.leetcode.combinationsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CombinationSumTest {
    private final CombinationSum combinationSum = new CombinationSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testThreeSum(List<List<Integer>> expected, int[] nums, int target) {
        List<List<Integer>> result = combinationSum.combinationSum(nums, target);
        Assertions.assertEquals(expected.size(), result.size());

        int matched = 0;
        for (List<Integer> threeNumbers : expected) {
            for (int j = 0; j < result.size(); j++) {
                List<Integer> resultThreeNumbers = expected.get(j);
                if (threeNumbers.containsAll(resultThreeNumbers) && resultThreeNumbers.containsAll(threeNumbers)) {
                    matched++;
                }
            }
        }

        Assertions.assertEquals(expected.size(), matched);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(List.of(List.of(2,2,3), List.of(7)), new int[]{2,3,6,7}, 7),
                Arguments.of(List.of(List.of(2,2,2,2), List.of(2,3,3), List.of(3,5)), new int[]{2,3,5}, 8),
                Arguments.of(List.of(List.of(2,2,2,3), List.of(2,7),List.of(3,3,3),List.of(3,6)), new int[]{2,3,6,7}, 9),
                Arguments.of(List.of(), new int[]{2}, 1),
                Arguments.of(List.of(List.of(1)), new int[]{1}, 1),
                Arguments.of(List.of(List.of(1,1)), new int[]{1}, 2)
        );
    }
}