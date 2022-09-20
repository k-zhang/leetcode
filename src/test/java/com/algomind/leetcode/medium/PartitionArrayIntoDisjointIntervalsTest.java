package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PartitionArrayIntoDisjointIntervalsTest {
    private final PartitionArrayIntoDisjointIntervals solution = new PartitionArrayIntoDisjointIntervals();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input) {
        Assertions.assertEquals(expected, solution.partitionDisjoint2(input));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new int[]{5,0,3,8,6}),
            Arguments.of(4, new int[]{1,1,1,0,6,12}),
            Arguments.of(1, new int[]{1,2,3,5,1,1,6,8}),
            Arguments.of(1, new int[]{1,2}),
            Arguments.of(2, new int[]{2,1,3}),
            Arguments.of(9, new int[]{8,1,8,4,5,3,10,9,3,12,11}),
            Arguments.of(1, new int[]{26,51,40,58,42,76,30,48,79,91}),
            Arguments.of(10, new int[]{8,1,8,4,5,3,10,9,3,2,13})
        );
    }
}