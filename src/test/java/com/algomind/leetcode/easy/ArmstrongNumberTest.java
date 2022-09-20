package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArmstrongNumberTest {
    private final ArmstrongNumber solution = new ArmstrongNumber();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, int num) {
        Assertions.assertEquals(expected, solution.isArmstrong(num));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, 153),
                Arguments.of(false, 123),
                Arguments.of(false, 9234567)
        );
    }
}