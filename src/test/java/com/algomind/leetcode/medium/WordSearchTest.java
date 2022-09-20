package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordSearchTest {
    private final WordSearch solution = new WordSearch();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, char[][] board, String word) {
        Assertions.assertEquals(expected, solution.exist(board, word));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"),
                Arguments.of(false, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"),
                Arguments.of(true, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "A"),
                Arguments.of(false, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "Z"),
                Arguments.of(true, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCC"),
                Arguments.of(false, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCFB")
        );
    }
}