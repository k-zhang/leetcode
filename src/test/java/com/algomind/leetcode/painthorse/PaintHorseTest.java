package com.algomind.leetcode.painthorse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PaintHorseTest {
    private final PaintHorse paintHorse = new PaintHorse();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] x){
        Assertions.assertEquals(expected, paintHorse.minCost(x));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{7,6,2}}),
                Arguments.of(10, new int[][]{{17,2,17},{16,16,5},{14,3,19}}),
                Arguments.of(12, new int[][]{{1,10,15},{2,100,8},{15,3,100}}),
                Arguments.of(8, new int[][]{{1000,1000,1},{17,4,3},{15,1,3}}),
                Arguments.of(27, new int[][]{{1,10,15},{2,100,8},{15,3,100},{17,3,50}}),
                Arguments.of(1002, new int[][]{{1,10,15},{1,1000,1000},{1,10000,100000}}),
                Arguments.of(82, new int[][]{{20,17,16},{10,14,15},{7,12,20},{4,9,3},{19,2,1},{7,7,16},{13,7,20},{19,11,6},{1,13,7},{2,13,4},{6,19,8},{17,9,19}})
        );
    }

}