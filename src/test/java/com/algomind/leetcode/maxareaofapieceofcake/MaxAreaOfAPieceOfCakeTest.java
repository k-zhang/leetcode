package com.algomind.leetcode.maxareaofapieceofcake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxAreaOfAPieceOfCakeTest {
    private final MaxAreaOfAPieceOfCake maxAreaOfAPieceOfCake = new MaxAreaOfAPieceOfCake();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Assertions.assertEquals(expected, maxAreaOfAPieceOfCake.maxArea(h, w, horizontalCuts, verticalCuts));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, 5, 4, new int[]{1,2,4}, new int[]{1,3}),
                Arguments.of(6, 5, 4, new int[]{3,1}, new int[]{1}),
                Arguments.of(9, 5, 4, new int[]{3}, new int[]{3}),
                Arguments.of(51, 50, 15, new int[]{37,40,41,30,27,10,31}, new int[]{2,1,9,5,4,12,6,13,11})
        );
    }
}