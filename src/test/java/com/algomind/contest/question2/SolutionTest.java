package com.algomind.contest.question2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, char[][] maze, int[] entrance) {
        Assertions.assertEquals(expected, solution.nearestExit(maze, entrance));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2}),
                Arguments.of(2, new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1,0}),
                Arguments.of(-1, new char[][]{{'.','+'}}, new int[]{0,0}),
                Arguments.of(1, new char[][]{{'.','.'}}, new int[]{0,1}),
                Arguments.of(12, new char[][]{{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','+','.','+'},{'+','+','+','+','+','.','+'}}, new int[]{0,1}),
                Arguments.of(7,  new char[][]{{'+','.','+','+','+','+','+'}
                                             ,{'+','.','+','.','.','.','+'}
                                             ,{'+','.','+','.','+','.','+'}
                                             ,{'+','.','.','.','.','.','+'}
                                             ,{'+','+','+','+','.','+','.'}}, new int[]{0,1}),
                Arguments.of(5,  new char[][]{
                        {'.','.','.','.','.','+','.','.','.'}
                        ,{'.','+','.','.','.','.','.','.','.'}
                        ,{'.','.','+','.','+','.','+','.','+'}
                        ,{'.','.','.','.','+','.','.','.','.'}
                        ,{'.','.','.','.','+','+','.','.','.'}
                        ,{'+','.','.','.','.','.','.','.','.'}
                        ,{'.','.','.','+','.','.','.','.','.'}
                        ,{'.','.','.','+','.','.','.','.','+'}
                        ,{'+','.','.','+','.','+','+','.','.'}}, new int[]{8,4})
        );
    }
}