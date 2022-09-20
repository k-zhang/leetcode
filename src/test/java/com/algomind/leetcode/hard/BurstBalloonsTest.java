package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BurstBalloonsTest {
    private final BurstBalloons burstBalloons = new BurstBalloons();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, burstBalloons.maxCoins(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(167, new int[]{3,1,5,8}),
                Arguments.of(10, new int[]{1,5}),
                Arguments.of(5, new int[]{5})
        );
    }
}