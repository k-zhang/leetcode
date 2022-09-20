package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindKClosestElementsTest {
    private final FindKClosestElements solution = new FindKClosestElements();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] arr, int k, int x) {
        var result = solution.findClosestElements(arr, k, x);
        int[] resultArray = result.stream().mapToInt(i -> i).toArray();
        Assertions.assertArrayEquals(expected, resultArray);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4,5}, 4, 3),
            Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4,5}, 4, -1),
            Arguments.of(new int[]{2,3,4,5}, new int[]{1,2,3,4,5}, 4, 6),
            Arguments.of(new int[]{1,2,4,5}, new int[]{1,2,4,5,6}, 4, 3),
            Arguments.of(new int[]{2,4,5,6}, new int[]{2,4,5,6,7}, 4, 3),
            Arguments.of(new int[]{5,6,7,9}, new int[]{2,4,5,6,7,9}, 4, 8),
            Arguments.of(new int[]{3}, new int[]{1,2,3,4,5}, 1, 3),
            Arguments.of(new int[]{1}, new int[]{1,2,3,4,5}, 1, -1),
            Arguments.of(new int[]{5}, new int[]{1,2,3,4,5}, 1, 6),
            Arguments.of(new int[]{2}, new int[]{1,2,4,5,6}, 1, 3),
            Arguments.of(new int[]{2}, new int[]{2,4,5,6,7}, 1, 3),
            Arguments.of(new int[]{7}, new int[]{2,4,5,6,7,9}, 1, 8),
            Arguments.of(new int[]{1}, new int[]{1}, 1, 8),
            Arguments.of(new int[]{1}, new int[]{1}, 1, -2),
            Arguments.of(new int[]{1}, new int[]{1}, 1, 1),
            Arguments.of(new int[]{5}, new int[]{1,5}, 1, 4),
            Arguments.of(new int[]{5}, new int[]{1,5}, 1, 5)
        );
    }
}