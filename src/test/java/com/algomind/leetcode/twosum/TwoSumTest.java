package com.algomind.leetcode.twosum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testTwoSum(int[] expected, int[] nums, int target) {
        Assertions.assertArrayEquals(expected, twoSum.twoSum(nums, target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1}, new int[]{2, 7, 11, 15}, 9),
                Arguments.of(new int[]{1, 2}, new int[]{3, 2, 4}, 6),
                Arguments.of(new int[]{0, 1}, new int[]{3, 3}, 6),
                Arguments.of(new int[]{0, 2}, new int[]{3, 6, -1}, 2),
                Arguments.of(new int[]{2, 3}, new int[]{1, 5, 0, 0}, 0)
        );
    }
}