package com.algomind.leetcode.removeduplicatesfromsortedarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveDuplicatesFromSortedArrayTest {
    private final RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testMaxSubArray(int expected, int[] input) {
        Assertions.assertEquals(expected, removeDuplicatesFromSortedArray.removeDuplicates(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, new int[]{1}),
                Arguments.of(2, new int[]{1,1,2}),
                Arguments.of(5, new int[]{0,0,1,1,1,2,2,3,3,4}),
                Arguments.of(1, new int[]{0,0,0,0,0,0,0,0,0,0,0}),
                Arguments.of(11, new int[]{0,1,2,3,4,5,6,7,8,9,10})
        );
    }
}