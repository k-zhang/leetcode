package com.algomind.leetcode.findthetownjudge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindTheTownJudgeTest {
    private final FindTheTownJudge findTheTownJudge = new FindTheTownJudge();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int n, int[][] trust) {
        var result = findTheTownJudge.findJudge1(n, trust);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(1, 1, new int[][]{}),
            Arguments.of(2, 2, new int[][]{{1,2}}),
            Arguments.of(3, 3, new int[][]{{1,3},{2,3}}),
            Arguments.of(-1, 3, new int[][]{{1,3},{2,3},{3,1}}),
            Arguments.of(-1, 4, new int[][]{{1,4},{2,4}}),
            Arguments.of(-1, 4, new int[][]{{1,4},{2,4},{3,2}}),
            Arguments.of(-1, 4, new int[][]{{1,4},{2,4},{1,2},{3,2},{4,2}})
        );
    }
}