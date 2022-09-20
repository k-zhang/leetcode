package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GrayCodeTest {
    private final GrayCode grayCode = new GrayCode();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int n) {
        var resultList = grayCode.grayCode1(n);
        var result = resultList.stream().mapToInt(i -> i).toArray();
        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0,1,3,2}, 2),
                Arguments.of(new int[]{0,1}, 1)
        );
    }
}