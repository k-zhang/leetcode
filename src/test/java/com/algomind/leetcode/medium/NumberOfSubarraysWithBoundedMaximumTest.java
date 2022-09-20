package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfSubarraysWithBoundedMaximumTest {
    private final NumberOfSubarraysWithBoundedMaximum solution = new NumberOfSubarraysWithBoundedMaximum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums, int left, int right){
        Assertions.assertEquals(expected, solution.numSubarrayBoundedMax(nums, left, right));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, new int[]{2,1,4,3}, 2, 3),
                Arguments.of(10, new int[]{2,1,3,2,4,3}, 2, 3),
                Arguments.of(7, new int[]{2,9,2,5,6}, 2, 8),
                Arguments.of(22, new int[]{73,55,36,5,55,14,9,7,72,52}, 32, 69)
        );
    }
}