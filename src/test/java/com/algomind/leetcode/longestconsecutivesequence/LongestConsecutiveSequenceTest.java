package com.algomind.leetcode.longestconsecutivesequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestConsecutiveSequenceTest {
    private final LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums) {
        Assertions.assertEquals(expected, solution.longestConsecutive(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, new int[]{100,4,200,1,3,2}),
                Arguments.of(9, new int[]{0,3,7,2,5,8,4,6,0,1}),
                Arguments.of(0, new int[]{}),
                Arguments.of(1, new int[]{1}),
                Arguments.of(1, new int[]{1,3,5}),
                Arguments.of(2, new int[]{1,3,4}),
                Arguments.of(1, new int[]{0,0,0})
        );
    }
}