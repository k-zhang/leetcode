package com.algomind.leetcode.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JumpGameTest {
    private final JumpGame jumpGame = new JumpGame();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int[] input) {
        Assertions.assertEquals(expected, jumpGame.canJump(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new int[]{0}),
                Arguments.of(true, new int[]{2,3,1,1,4}),
                Arguments.of(false, new int[]{3,2,1,0,4}),
                Arguments.of(true, new int[]{3,2,2,0,4,0,1}),
                Arguments.of(false, new int[]{3,2,2,0,0,1}),
                Arguments.of(false, new int[]{3,2,2,0,2,1,0,2}),
                Arguments.of(false, new int[]{0,2,2,1}),
                Arguments.of(true, new int[]{2,0,0})
        );
    }
}