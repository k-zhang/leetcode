package com.algomind.leetcode.stonegame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StoneGameTest {
    private final StoneGame stoneGame = new StoneGame();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testStoneGame(boolean expected, int[] input) {
        Assertions.assertEquals(expected, stoneGame.stoneGame(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new int[]{5,3,4,5}),
                Arguments.of(true, new int[]{50,1000,1,2})
        );
    }
}