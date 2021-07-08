package com.algomind.leetcode.maximumlengthofrepeatedsubarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumLengthOfRepeatedSubarrayTest {
    private final MaximumLengthOfRepeatedSubarray solution = new MaximumLengthOfRepeatedSubarray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums1, int[] nums2) {
        Assertions.assertEquals(expected, solution.findLength1(nums1, nums2));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}),
            Arguments.of(0, new int[]{1,2,3,2,1}, new int[]{7,5,9,8,6}),
            Arguments.of(1, new int[]{1,2,3,2,1}, new int[]{7,5,9,8,3}),
            Arguments.of(1, new int[]{1,2,3,2,1}, new int[]{3}),
            Arguments.of(5, new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}),
            Arguments.of(3, new int[]{1,0,0,0,1,0,0,1,0,0}, new int[]{0,1,1,1,0,1,1,1,0,0}),
            Arguments.of(1, new int[]{1}, new int[]{1}),
            Arguments.of(0, new int[]{1}, new int[]{2})
        );
    }
}