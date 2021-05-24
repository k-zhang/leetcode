package com.algomind.leetcode.searchinrotatedsortedarray2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInRotatedSortedArray2Test {
    private final SearchInRotatedSortedArray2 searchInRotatedSortedArray2 = new SearchInRotatedSortedArray2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testSearchInRotatedSortedArray(boolean expected, int[] input, int target) {
        Assertions.assertEquals(expected, searchInRotatedSortedArray2.search(input,target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 0),
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,1,1,2}, 0),
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 1),
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 2),
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 5),
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 6),
                Arguments.of(true, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 7),
                Arguments.of(false, new int[]{2,4,4,5,6,7,0,0,1,1,2}, 3),

                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 0),
                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 1),
                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 2),
                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 4),
                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 5),
                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 6),
                Arguments.of(true, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 7),
                Arguments.of(false, new int[]{0,0,1,1,2,2,4,4,5,6,7}, 3),

                Arguments.of(true, new int[]{0}, 0),
                Arguments.of(false, new int[]{0}, 1),

                Arguments.of(true, new int[]{2,3,1}, 2),
                Arguments.of(true, new int[]{2,3,1}, 3),
                Arguments.of(true, new int[]{2,3,1}, 1),

                Arguments.of(true, new int[]{3,1,2}, 3),
                Arguments.of(true, new int[]{3,1,2}, 1),
                Arguments.of(true, new int[]{3,1,2}, 2),

                Arguments.of(true, new int[]{1,0,1,1,1}, 0),
                Arguments.of(false, new int[]{1,1}, 0)
        );
    }
}