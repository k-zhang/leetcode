package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ShuffleAnArrayTest {
    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] nums) {
        ShuffleAnArray solution = new ShuffleAnArray(nums);

        int[] result = solution.shuffle();
        var expectedSet = Arrays.stream(expected).boxed().collect(Collectors.toSet());
        var resultSet = Arrays.stream(result).boxed().collect(Collectors.toSet());
        Assertions.assertEquals(expectedSet, resultSet);

        int[] resetted = solution.reset();
        Assertions.assertArrayEquals(nums, resetted);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{3,1,2}, new int[]{1,2,3})
        );
    }
}