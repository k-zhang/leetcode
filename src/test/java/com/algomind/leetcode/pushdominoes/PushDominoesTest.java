package com.algomind.leetcode.pushdominoes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PushDominoesTest {
    private final PushDominoes solution = new PushDominoes();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String dominoes) {
        Assertions.assertEquals(expected, solution.pushDominoes1(dominoes));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("RR.L", "RR.L"),
            Arguments.of("LL.RR.LLRRLL..", ".L.R...LR..L.."),
            Arguments.of(".", "."),
            Arguments.of("L", "L"),
            Arguments.of("R", "R"),
            Arguments.of("LR", "LR"),
            Arguments.of("RL", "RL"),
            Arguments.of("R.L", "R.L"),
            Arguments.of("L.R", "L.R")
        );
    }
}