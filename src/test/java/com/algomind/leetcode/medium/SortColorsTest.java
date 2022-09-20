package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SortColorsTest {
    private final SortColors solution = new SortColors();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] nums) {
        solution.sortColors1(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0,0,1,1,2,2}, new int[]{2,0,2,1,1,0}),
                Arguments.of(new int[]{0,1,2}, new int[]{2,0,1}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0,0,0,1,1,1,2,2,2}, new int[]{2,2,2,1,1,1,0,0,0})
        );
    }
}