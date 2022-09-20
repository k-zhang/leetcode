package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MergeIntervalsTest {
    private final MergeIntervals mergeIntervals = new MergeIntervals();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int[][] intervals) {
        Assertions.assertArrayEquals(expected, mergeIntervals.merge1(intervals));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,6},{8,10},{15,18}}, new int[][]{{1,3},{2,6},{8,10},{15,18}}),
                Arguments.of(new int[][]{{1,6},{8,10},{15,18}}, new int[][]{{15,18},{1,3},{8,10},{2,6}}),
                Arguments.of(new int[][]{{1,3},{4,6},{8,10},{15,18}}, new int[][]{{1,3},{4,6},{8,10},{15,18}}),
                Arguments.of(new int[][]{{1,5}}, new int[][]{{1,4},{4,5}}),
                Arguments.of(new int[][]{{1,4}}, new int[][]{{1,4}}),
                Arguments.of(new int[][]{{1,100}}, new int[][]{{1,100},{4,6},{8,10},{15,18}}),
                Arguments.of(new int[][]{{1,100}}, new int[][]{{15,18},{1,100},{8,10},{2,6}}),
                Arguments.of(new int[][]{{1,18}}, new int[][]{{1,4},{4,6},{6,10},{10,18}}),
                Arguments.of(new int[][]{{1,200}}, new int[][]{{1,4},{4,100},{80,100},{5,200}})
        );
    }
}