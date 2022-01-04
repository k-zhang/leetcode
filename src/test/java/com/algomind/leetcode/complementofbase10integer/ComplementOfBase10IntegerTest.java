package com.algomind.leetcode.complementofbase10integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ComplementOfBase10IntegerTest {
    private final ComplementOfBase10Integer solution = new ComplementOfBase10Integer();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testThreeSum(int expected, int n) {
        var result = solution.bitwiseComplement(n);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, 5),
            Arguments.of(0, 7),
            Arguments.of(5, 10),
            Arguments.of(1, 0)
        );
    }
}