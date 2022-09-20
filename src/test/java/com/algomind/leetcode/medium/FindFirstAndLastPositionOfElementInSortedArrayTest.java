package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindFirstAndLastPositionOfElementInSortedArrayTest {
    private final FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMaxSubArray(int[] expected, int[] input, int target) {
        Assertions.assertArrayEquals(expected, findFirstAndLastPositionOfElementInSortedArray.searchRange(input,target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{3,4}, new int[]{5,7,7,8,8,10}, 8),
            Arguments.of(new int[]{0,5}, new int[]{8,8,8,8,8,8}, 8),
            Arguments.of(new int[]{0,0}, new int[]{5,7,7,8,8,10}, 5),
            Arguments.of(new int[]{5,5}, new int[]{5,7,7,8,8,10}, 10),
            Arguments.of(new int[]{1,2}, new int[]{0,7,7,8,8,10}, 7),
            Arguments.of(new int[]{-1,-1}, new int[]{5,7,7,8,8,10}, 6),
            Arguments.of(new int[]{-1,-1}, new int[]{1}, 0),
            Arguments.of(new int[]{0,0}, new int[]{1}, 1),
            Arguments.of(new int[]{0,1}, new int[]{1,1}, 1),
            Arguments.of(new int[]{-1,-1}, new int[]{}, 0)
        );
    }
}