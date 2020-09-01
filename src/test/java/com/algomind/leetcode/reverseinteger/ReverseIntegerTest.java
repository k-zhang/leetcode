package com.algomind.leetcode.reverseinteger;

import com.algomind.leetcode.reverseinteger.ReverseInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseIntegerTest {
    ReverseInteger reverseInteger = new ReverseInteger();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testReverse1(int expected, int x) {
        Assertions.assertEquals(expected, reverseInteger.reverse(x));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testReverse2(int expected, int x) {
        Assertions.assertEquals(expected, reverseInteger.reverse2(x));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(0, 0),
                Arguments.of(12, 21),
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(0, 2147483647),
                Arguments.of(0, -2147483648)
        );
    }
}