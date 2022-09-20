package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInRotatedSortedArrayTest {
    private final SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testSearchInRotatedSortedArray(int expected, int[] input, int target) {
        Assertions.assertEquals(expected, searchInRotatedSortedArray.search(input,target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, new int[]{4,5,6,7,0,1,2}, 4),
                Arguments.of(1, new int[]{4,5,6,7,0,1,2}, 5),
                Arguments.of(2, new int[]{4,5,6,7,0,1,2}, 6),
                Arguments.of(3, new int[]{4,5,6,7,0,1,2}, 7),
                Arguments.of(4, new int[]{4,5,6,7,0,1,2}, 0),
                Arguments.of(5, new int[]{4,5,6,7,0,1,2}, 1),
                Arguments.of(6, new int[]{4,5,6,7,0,1,2}, 2),
                Arguments.of(-1, new int[]{4,5,6,7,0,1,2}, 3),

                Arguments.of(0, new int[]{1,2,4,5,6,7,0}, 1),
                Arguments.of(1, new int[]{1,2,4,5,6,7,0}, 2),
                Arguments.of(2, new int[]{1,2,4,5,6,7,0}, 4),
                Arguments.of(3, new int[]{1,2,4,5,6,7,0}, 5),
                Arguments.of(4, new int[]{1,2,4,5,6,7,0}, 6),
                Arguments.of(5, new int[]{1,2,4,5,6,7,0}, 7),
                Arguments.of(6, new int[]{1,2,4,5,6,7,0}, 0),
                Arguments.of(-1, new int[]{1,2,4,5,6,7,0}, 3),

                Arguments.of(0, new int[]{0,1,2,4,5,6,7}, 0),
                Arguments.of(1, new int[]{0,1,2,4,5,6,7}, 1),
                Arguments.of(2, new int[]{0,1,2,4,5,6,7}, 2),
                Arguments.of(3, new int[]{0,1,2,4,5,6,7}, 4),
                Arguments.of(4, new int[]{0,1,2,4,5,6,7}, 5),
                Arguments.of(5, new int[]{0,1,2,4,5,6,7}, 6),
                Arguments.of(6, new int[]{0,1,2,4,5,6,7}, 7),
                Arguments.of(-1, new int[]{0,1,2,4,5,6,7}, 3),

                Arguments.of(0, new int[]{60,70,0,10,20,40,50}, 60),
                Arguments.of(1, new int[]{60,70,0,10,20,40,50}, 70),
                Arguments.of(2, new int[]{60,70,0,10,20,40,50}, 0),
                Arguments.of(3, new int[]{60,70,0,10,20,40,50}, 10),
                Arguments.of(4, new int[]{60,70,0,10,20,40,50}, 20),
                Arguments.of(5, new int[]{60,70,0,10,20,40,50}, 40),
                Arguments.of(6, new int[]{60,70,0,10,20,40,50}, 50),
                Arguments.of(-1, new int[]{60,70,0,10,20,40,50}, 30),

                Arguments.of(0, new int[]{0,1,2,4,5,6,7,8}, 0),
                Arguments.of(1, new int[]{0,1,2,4,5,6,7,8}, 1),
                Arguments.of(2, new int[]{0,1,2,4,5,6,7,8}, 2),
                Arguments.of(3, new int[]{0,1,2,4,5,6,7,8}, 4),
                Arguments.of(4, new int[]{0,1,2,4,5,6,7,8}, 5),
                Arguments.of(5, new int[]{0,1,2,4,5,6,7,8}, 6),
                Arguments.of(6, new int[]{0,1,2,4,5,6,7,8}, 7),
                Arguments.of(7, new int[]{0,1,2,4,5,6,7,8}, 8),
                Arguments.of(-1, new int[]{0,1,2,4,5,6,7,8}, 3),

                Arguments.of(0, new int[]{1,2}, 1),
                Arguments.of(1, new int[]{1,2}, 2),

                Arguments.of(0, new int[]{2,1}, 2),
                Arguments.of(1, new int[]{2,1}, 1),

                Arguments.of(0, new int[]{1,2,3}, 1),
                Arguments.of(1, new int[]{1,2,3}, 2),
                Arguments.of(2, new int[]{1,2,3}, 3),

                Arguments.of(0, new int[]{2,3,1}, 2),
                Arguments.of(1, new int[]{2,3,1}, 3),
                Arguments.of(2, new int[]{2,3,1}, 1),

                Arguments.of(0, new int[]{3,1,2}, 3),
                Arguments.of(1, new int[]{3,1,2}, 1),
                Arguments.of(2, new int[]{3,1,2}, 2),

                Arguments.of(-1, new int[]{1}, 0),
                Arguments.of(0, new int[]{1}, 1)
        );
    }
}