package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarPoolingTest {
    private final CarPooling solution = new CarPooling();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int[][] trips, int capacity) {
        Assertions.assertEquals(expected, solution.carPooling1(trips, capacity));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(false, new int[][]{{2,1,5},{3,3,7}}, 4),
            Arguments.of(true, new int[][]{{2,1,5},{3,3,7}}, 5),
            Arguments.of(true, new int[][]{{5,1,5}}, 5),
            Arguments.of(false, new int[][]{{6,1,5}}, 5),
            Arguments.of(true, new int[][]{{2,1,5},{4,5,8}}, 5),
            Arguments.of(true, new int[][]{{3,2,8},{4,4,6},{10,8,9}}, 11),
            Arguments.of(true, new int[][]{{3,2,4},{4,5,7},{10,8,9}}, 11),
            Arguments.of(false, new int[][]{{7,5,6},{6,7,8},{10,1,6}}, 16),
            Arguments.of(true, new int[][]{{9,3,4},{9,1,7},{4,2,4},{7,4,5}}, 23)
        );
    }
}