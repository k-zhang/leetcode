package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CombinationSum2Test {
    private final CombinationSum2 combinationSum2 = new CombinationSum2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testThreeSum(List<List<Integer>> expected, int[] nums, int target) {
        List<List<Integer>> result = combinationSum2.combinationSum2(nums, target);
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
            Arguments.of(List.of(List.of(1,1,6),List.of(1,2,5),List.of(1,7),List.of(2,6)), new int[]{10,1,2,7,6,1,5}, 8),
            Arguments.of(List.of(List.of(1,2,2),List.of(5)), new int[]{2,5,2,1,2}, 5),
            Arguments.of(List.of(List.of(1,1,1,1,1)), new int[]{1,1,1,1,1}, 5),
            Arguments.of(List.of(List.of(1,1,1,2)), new int[]{1,1,1,1,2}, 5),
            Arguments.of(List.of(List.of(1,1,1,2),List.of(1,1,1,1,1)), new int[]{1,1,1,1,1,2}, 5),
            Arguments.of(List.of(), new int[]{2,2,2,2}, 5),
            Arguments.of(List.of(List.of(2,2,3,3),List.of(1,1,2,3,3),List.of(10)), new int[]{1,1,2,2,3,3,10}, 10),
            Arguments.of(List.of(List.of(5,5),List.of(2,2,2,2,2)), new int[]{5,5,5,2,2,5,2,5,2,2}, 10)
        );
    }
}