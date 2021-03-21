package com.algomind.leetcode.countingbits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountingBitsTest {
    private final CountingBits countingBits = new CountingBits();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testBestTimeToBuySellStock1(int[] expected, int num) {
        Assertions.assertArrayEquals(expected, countingBits.countBits(num));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{0}, 0),
            Arguments.of(new int[]{0,1}, 1),
            Arguments.of(new int[]{0,1,1}, 2),
            Arguments.of(new int[]{0,1,1,2,1,2}, 5),
            Arguments.of(new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4}, 15),
            Arguments.of(new int[]{0,1, 1,2, 1,2,2,3, 1,2,2,3,2,3,3,4, 1,2,2,3,2,3,3,4,2,3,3,4}, 27),
            Arguments.of(new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2}, 40),
            Arguments.of(new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6}, 63)
        );
    }
}