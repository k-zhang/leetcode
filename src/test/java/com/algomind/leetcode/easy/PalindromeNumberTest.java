package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PalindromeNumberTest {
    private final PalindromeNumber palindromeNumber = new PalindromeNumber();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testPalindromeNumber(boolean expected, int x){
        Assertions.assertEquals(expected, palindromeNumber.isPalindrome(x));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, 0),
                Arguments.of(true, 5),
                Arguments.of(true, 121),
                Arguments.of(false, -121),
                Arguments.of(false, 10),
                Arguments.of(false, 2147483647),
                Arguments.of(false, -2147483648)
        );
    }
}