package com.algomind.leetcode.trappingrainwater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TrappingRainWaterTest {
    private final TrappingRainWater trappingRainWater = new TrappingRainWater();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testTrappingRainWater(int expected, int[] height) {
        Assertions.assertEquals(expected, trappingRainWater.trap(height));
        Assertions.assertEquals(expected, trappingRainWater.trap1(height));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(9, new int[]{4,2,0,3,2,5}),
                Arguments.of(10, new int[]{2,0,1,0,2,0,1,0,3})
        );
    }
}