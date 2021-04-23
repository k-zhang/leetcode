package com.algomind.leetcode.mergesortedarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MergeSortedArrayTest {
    private final MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] nums1, int m, int[] nums2, int n) {
        mergeSortedArray.merge1(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expected, nums1);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,2,3,5,6}, new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3),
                Arguments.of(new int[]{1,2,3,4,5,6}, new int[]{1,2,3,0,0,0}, 3, new int[]{4,5,6}, 3),
                Arguments.of(new int[]{1,2,3,4,5,6}, new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3),
                Arguments.of(new int[]{1}, new int[]{1}, 1, new int[]{}, 0),
                Arguments.of(new int[]{1}, new int[]{0}, 0, new int[]{1}, 1),
                Arguments.of(new int[]{}, new int[]{}, 0, new int[]{}, 0)
        );
    }
}