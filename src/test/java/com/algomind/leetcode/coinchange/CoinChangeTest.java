package com.algomind.leetcode.coinchange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CoinChangeTest {
    private final CoinChange coinChange = new CoinChange();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] coins, int amount) {
        Assertions.assertEquals(expected, coinChange.coinChange(coins, amount));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new int[]{1,2,5}, 11),
            Arguments.of(3, new int[]{1,5,8}, 11),
            Arguments.of(20, new int[]{186,419,83,408}, 6249),
            Arguments.of(-1, new int[]{2}, 3),
            Arguments.of(-1, new int[]{3}, 2),
            Arguments.of(0, new int[]{1}, 0),
            Arguments.of(1, new int[]{1}, 1),
            Arguments.of(2, new int[]{1}, 2)
        );
    }
}


