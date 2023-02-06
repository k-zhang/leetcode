package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ShuffleTheArrayTest {
    private final ShuffleTheArray shuffleTheArray = new ShuffleTheArray();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void test(int[] expected, int[] nums, int n) {
        var result = shuffleTheArray.shuffle(nums, n);
        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of(new int[]{2,3,5,4,1,7}, new int[]{2,5,1,3,4,7}, 3),
            Arguments.of(new int[]{1,4,2,3,3,2,4,1}, new int[]{1,2,3,4,4,3,2,1}, 4),
            Arguments.of(new int[]{1,2,1,2}, new int[]{1,1,2,2}, 2),
            Arguments.of(new int[]{1,2}, new int[]{1,2}, 1)
        );
    }
}