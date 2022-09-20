package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JumpGame2Test {
    private final JumpGame2 jumpGame2 = new JumpGame2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, jumpGame2.jump(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[]{2,3,1,1,4}),
                Arguments.of(2, new int[]{2,3,0,1,4}),
                Arguments.of(0, new int[]{1}),
                Arguments.of(1, new int[]{1,1}),
                Arguments.of(1, new int[]{2,0,1}),
                Arguments.of(2, new int[]{6,4,1,1,1,1,1,4}),
                Arguments.of(2, new int[]{6,4,1,1,1,1,2,4}),
                Arguments.of(3, new int[]{1,4,1,4,1,1,2,4}),
                Arguments.of(3, new int[]{1,4,1,4,3,1,2,4}),
                Arguments.of(3, new int[]{1,4,10,4,3,1,2,4})
        );
    }
}