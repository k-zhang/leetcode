package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CountOfSmallerNumbersAfterSelfTest {
    private final CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] nums) {
        List<Integer> result = solution.countSmaller(nums);
        Assertions.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{-1}),
                Arguments.of(new int[]{0,0}, new int[]{-1,-1}),
                Arguments.of(new int[]{2,1,1,0}, new int[]{5,2,6,1}),
                Arguments.of(new int[]{1,1,1,0}, new int[]{5,5,5,1}),
                Arguments.of(new int[]{0,0,0,0}, new int[]{5,5,5,5})
        );
    }
}