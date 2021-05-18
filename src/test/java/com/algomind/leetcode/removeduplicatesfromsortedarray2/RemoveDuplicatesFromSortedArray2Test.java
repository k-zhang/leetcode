package com.algomind.leetcode.removeduplicatesfromsortedarray2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveDuplicatesFromSortedArray2Test {
    private final RemoveDuplicatesFromSortedArray2 removeDuplicatesFromSortedArray2 = new RemoveDuplicatesFromSortedArray2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, removeDuplicatesFromSortedArray2.removeDuplicates1(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(5, new int[]{1,1,1,2,2,3}),
                Arguments.of(7, new int[]{0,0,1,1,1,1,2,3,3}),
                Arguments.of(9, new int[]{1,1,1,2,2,2,2,3,3,3,4,5,7}),
                Arguments.of(2, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1}),
                Arguments.of(1, new int[]{1}),
                Arguments.of(2, new int[]{1,1}),
                Arguments.of(2, new int[]{1,2}),
                Arguments.of(3, new int[]{1,2,3}),
                Arguments.of(2, new int[]{1,1,1}),
                Arguments.of(7, new int[]{1,2,3,4,5,6,7}),
                Arguments.of(14, new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,7}),
                Arguments.of(14, new int[]{1,1,1,1,2,2,2,3,3,3,3,4,4,5,5,5,6,6,7,7}),
                Arguments.of(9, new int[]{1,1,1,1,2,3,4,5,6,7,7,7,7,7})
        );
    }
}