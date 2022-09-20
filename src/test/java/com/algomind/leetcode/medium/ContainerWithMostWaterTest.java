package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ContainerWithMostWaterTest {
    private final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testContainerWithMostWater(int expected, int[] input) {
        Assertions.assertEquals(expected, containerWithMostWater.maxArea(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, new int[]{1,1}),
                Arguments.of(16, new int[]{4,3,2,1,4}),
                Arguments.of(2, new int[]{1,2,1}),
                Arguments.of(49, new int[]{1,8,6,2,5,4,8,3,7}),
                Arguments.of(18, new int[]{3,4,5,6,1,2,3}),
                Arguments.of(0, new int[]{0,0}),
                Arguments.of(0, new int[]{0,1}),
                Arguments.of(0, new int[]{0,1,0})
        );
    }
}