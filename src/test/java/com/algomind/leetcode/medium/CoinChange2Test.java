package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CoinChange2Test {
    private final CoinChange2 coinChange2 = new CoinChange2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int amount, int[] coins) {
        Assertions.assertEquals(expected, coinChange2.change(amount, coins));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, 5, new int[]{1,2,5}),
                Arguments.of(0, 3, new int[]{2}),
                Arguments.of(1, 10, new int[]{10}),
                Arguments.of(3119, 200, new int[]{1,3,5,50,100}),
                Arguments.of(1, 0, new int[]{1,3,5,50,100})
        );
    }
}