package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatchsticksToSquareTest {
    private final MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int[] matchsticks) {
        Assertions.assertEquals(expected, matchsticksToSquare.makeSquare(matchsticks));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(true, new int[]{1, 1, 2, 2, 2}),
            Arguments.of(true, new int[]{1, 1, 2, 2, 2, 0}),
            Arguments.of(false, new int[]{3, 3, 3, 3, 4}),
            Arguments.of(false, new int[]{3, 3, 3, 3, 4, 0}),
            Arguments.of(false, new int[]{4}),
            Arguments.of(false, new int[]{0,0,0,0}),
            Arguments.of(false, new int[]{3,3,3,2}),
            Arguments.of(true, new int[]{3,3,3,2,1}),
            Arguments.of(true, new int[]{5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}),
            Arguments.of(true, new int[]{5,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1}),
            Arguments.of(false, new int[]{5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}),
            Arguments.of(true, new int[]{10,6,5,5,5,3,3,3,2,2,2,2})
        );
    }
}