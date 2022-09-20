package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FourSumTest {
    private final FourSum fourSum = new FourSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testFourSum(List<List<Integer>> expected, int[] nums, int target) {
        List<List<Integer>> result = fourSum.fourSum(nums, target);
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
                Arguments.of(List.of(List.of(-2,-1,1,2),List.of(-2,0,0,2),List.of(-1,0,0,1)), new int[]{1,0,-1,0,-2,2}, 0),
                Arguments.of(List.of(), new int[]{1,1,1,1,1,1}, 0),
                Arguments.of(List.of(List.of(1,-1,1,-1)), new int[]{1,-1,1,-1,1,1}, 0),
                Arguments.of(List.of(), new int[]{1,-1,1,-1,1,1}, 1),
                Arguments.of(List.of(List.of(-1,1,1,1)), new int[]{1,-1,1,-1,1,1}, 2),
                Arguments.of(List.of(), new int[]{10,12,14,16,18,20}, 1),
                Arguments.of(List.of(List.of(10,12,14,16)), new int[]{10,12,14,16,18,20}, 52),
                Arguments.of(List.of(List.of(10,12,14,16)), new int[]{20,18,16,14,12,10}, 52),
                Arguments.of(List.of(List.of(10,12,14,16), List.of(0,14,18,20)), new int[]{20,18,16,14,0,0,0,0,0,12,10}, 52),
                Arguments.of(List.of(List.of(-5,-4,-3,1)), new int[]{1,-2,-5,-4,-3,3,3,5}, -11),
                Arguments.of(List.of(List.of(-2,-1,1,2),List.of(-1,-1,1,1)), new int[]{-2,-1,-1,1,1,2,2}, 0),
                Arguments.of(List.of(), new int[]{-10,-12,-14,-16,-18,-20}, 1),
                Arguments.of(List.of(), new int[]{}, 3),
                Arguments.of(List.of(), new int[]{1,2}, 3),
                Arguments.of(List.of(), new int[]{1,2,3}, 3)
        );
    }
}