package com.algomind.leetcode.zigzagconversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ZigZagConversionTest {
    ZigZagConversion zigZagConversion = new ZigZagConversion();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testZigZagConversion1(String expected, String s, int numRows) {
        long start = System.nanoTime();
        Assertions.assertEquals(expected, zigZagConversion.convert1(s, numRows));
        long end = System.nanoTime();

        System.out.println(end - start);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testZigZagConversion2(String expected, String s, int numRows) {
        long start = System.nanoTime();
        Assertions.assertEquals(expected, zigZagConversion.convert2(s, numRows));
        long end = System.nanoTime();

        System.out.println(end - start);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("PAHNAPLSIIGYIR", "PAYPALISHIRING", 3),
                Arguments.of("PINALSIGYAHRPI", "PAYPALISHIRING", 4),
                Arguments.of("PHASIYIRPLIGAN", "PAYPALISHIRING", 5),
                Arguments.of("ABCD", "ABCD", 4),
                Arguments.of("AB,.CDE", "AB,.CDE", 7),
                Arguments.of("ACB.D,E", "AB,.CDE", 3),
                Arguments.of("A", "A", 1),
                Arguments.of("AB", "AB", 1)
        );
    }
}