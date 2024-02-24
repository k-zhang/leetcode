package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AddBinaryTest {
    private final AddBinary solution = new AddBinary();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String a, String b) {
        Assertions.assertEquals(expected, solution.addBinary2(a, b));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("100", "11", "1"),
                Arguments.of("10101", "1010", "1011"),
                Arguments.of("110001", "101111", "10"),
                Arguments.of("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000", "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011")
        );
    }
}