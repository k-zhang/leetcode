package com.algomind.leetcode.threeequalparts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ThreeEqualPartsTest {
    private final ThreeEqualParts solution = new ThreeEqualParts();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] nums) {
        Assertions.assertArrayEquals(expected, solution.threeEqualParts(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{0,3}, new int[]{1,0,1,0,1}),
            Arguments.of(new int[]{-1,-1}, new int[]{1,1,0,1,1}),
            Arguments.of(new int[]{0,2}, new int[]{1,1,0,0,1}),
            Arguments.of(new int[]{0,4}, new int[]{0,0,0,0,0}),
            Arguments.of(new int[]{-1,-1}, new int[]{1,1,0,1,1,1,0,1}),
            Arguments.of(new int[]{-1,-1}, new int[]{1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0}),
            Arguments.of(new int[]{1,4}, new int[]{0,1,0,1,1})
        );
    }
}