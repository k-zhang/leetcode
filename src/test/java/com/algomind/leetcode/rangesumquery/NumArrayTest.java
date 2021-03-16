package com.algomind.leetcode.rangesumquery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumArrayTest {
    @ParameterizedTest
    @MethodSource("provideData")
    public void testBestTimeToBuySellStock1(int expected, int left, int right) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assertions.assertEquals(expected, numArray.sumRange(left, right));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 0, 2),
                Arguments.of(-1, 2, 5),
                Arguments.of(-3, 0, 5)
        );
    }
}