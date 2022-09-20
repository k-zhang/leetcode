package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInsertPositionTest {
    private final SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMaxSubArray(int expected, int[] input, int target) {
        Assertions.assertEquals(expected, searchInsertPosition.searchInsert(input,target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[]{1,3,5,6}, 5),
                Arguments.of(1, new int[]{1,3,5,6}, 2),
                Arguments.of(2, new int[]{1,3,5,6}, 4),
                Arguments.of(4, new int[]{1,3,5,6}, 7),
                Arguments.of(0, new int[]{1,3,5,6}, 0),
                Arguments.of(0, new int[]{1}, 0),
                Arguments.of(3, new int[]{-10,-5,-2,1,3,5,6}, 0)
        );
    }
}