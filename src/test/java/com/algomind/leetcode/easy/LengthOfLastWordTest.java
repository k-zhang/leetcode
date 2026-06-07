package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LengthOfLastWordTest {
    private static final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testLengthOfLastWord(int expected, String sentence) {
        var result = lengthOfLastWord.lengthOfLastWord(sentence);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testLengthOfLastWord2(int expected, String sentence) {
        var result = lengthOfLastWord.lengthOfLastWord2(sentence);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(5, "Hello World"),
                Arguments.of(5, "Hello     World"),
                Arguments.of(5, "          Hello     World        "),
                Arguments.of(10, "HelloWorld"),
                Arguments.of(10, "          HelloWorld"),
                Arguments.of(5, "          Hi    Hello    World    ")
        );
    }
}