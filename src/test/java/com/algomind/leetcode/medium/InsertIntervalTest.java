package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InsertIntervalTest {
    private final InsertInterval insertInterval = new InsertInterval();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int[][] intervals, int[] newInterval) {
        Assertions.assertArrayEquals(expected, insertInterval.insert1(intervals, newInterval));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2},{3,10},{12,16}}, new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}),
                Arguments.of(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16},{18,20}}, new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{18,20}),
                Arguments.of(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[][]{{3,5},{6,7},{8,10},{12,16}}, new int[]{1,2}),
                Arguments.of(new int[][]{{1,5},{6,9}}, new int[][]{{1,3},{6,9}}, new int[]{2,5}),
                Arguments.of(new int[][]{{2,5}}, new int[][]{}, new int[]{2,5}),
                Arguments.of(new int[][]{{1,5}}, new int[][]{{1,5}}, new int[]{2,3}),
                Arguments.of(new int[][]{{1,7}}, new int[][]{{1,5}}, new int[]{2,7}),
                Arguments.of(new int[][]{{1,100}}, new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{1,100}),
                Arguments.of(new int[][]{{1,2},{3,100}}, new int[][]{{1,2},{4,5},{6,7},{8,10},{12,16}}, new int[]{3,100}),
                Arguments.of(new int[][]{{1,7},{8,10},{12,16}}, new int[][]{{6,7},{8,10},{12,16}}, new int[]{1,7}),
                Arguments.of(new int[][]{{1,11},{12,16}}, new int[][]{{6,7},{8,10},{12,16}}, new int[]{1,11}),
                Arguments.of(new int[][]{{1,100}}, new int[][]{{3,5},{6,7},{8,10},{12,16}}, new int[]{1,100}),
                Arguments.of(new int[][]{{1,11},{12,16}}, new int[][]{{3,5},{6,7},{8,10},{12,16}}, new int[]{1,11}),
                Arguments.of(new int[][]{{1,16}}, new int[][]{{3,5},{6,7},{8,10},{12,16}}, new int[]{1,12})
        );
    }
}