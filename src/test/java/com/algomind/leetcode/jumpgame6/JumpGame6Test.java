package com.algomind.leetcode.jumpgame6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JumpGame6Test {
    private final JumpGame6 jumpGame6 = new JumpGame6();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums, int k) {
        Assertions.assertEquals(expected, jumpGame6.maxResult(nums, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(7, new int[]{1,-1,-2,4,-7,3}, 2),
                Arguments.of(17, new int[]{10,-5,-2,4,0,3}, 3),
                Arguments.of(0, new int[]{1,-5,-20,4,-1,3,-6,-3}, 2)
        );
    }
}