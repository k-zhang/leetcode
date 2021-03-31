package com.algomind.leetcode.nextpermutation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class NextPermutationTest {
    private final NextPermutation nextPermutation = new NextPermutation();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testNextPermutation(int[] expected, int[] nums) {
        System.out.println("Input   : " + Arrays.toString(nums));
        nextPermutation.nextPermutation1(nums);
        System.out.println("Result  : " + Arrays.toString(nums));
        System.out.println("Expected: " + Arrays.toString(expected));
        Assertions.assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1,3,2}, new int[]{1,2,3}),
                Arguments.of(new int[]{1,2,3}, new int[]{3,2,1}),
                Arguments.of(new int[]{3,1,2}, new int[]{2,3,1}),
                Arguments.of(new int[]{3,2,4}, new int[]{2,4,3}),
                Arguments.of(new int[]{1,5,1}, new int[]{1,1,5}),
                Arguments.of(new int[]{7,1,8}, new int[]{1,8,7}),
                Arguments.of(new int[]{0,0,1}, new int[]{1,0,0}),
                Arguments.of(new int[]{1,1,0}, new int[]{1,0,1}),
                Arguments.of(new int[]{0,1,0}, new int[]{0,0,1}),
                Arguments.of(new int[]{4,2,0,3,0,2,2}, new int[]{4,2,0,2,3,2,0}),
                Arguments.of(new int[]{2,2,1,1,2,2,2,2}, new int[]{2,1,2,2,2,2,2,1}),
                Arguments.of(new int[]{3,4,3,1,3,4}, new int[]{3,4,1,4,3,3}),
                Arguments.of(new int[]{2,2,4,0,1,4,0,2,4}, new int[]{2,2,4,0,1,2,4,4,0}),
                Arguments.of(new int[]{1,7,0,8}, new int[]{1,0,8,7}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1,1}, new int[]{1,1}),
                Arguments.of(new int[]{0,1}, new int[]{1,0})
        );
    }
}