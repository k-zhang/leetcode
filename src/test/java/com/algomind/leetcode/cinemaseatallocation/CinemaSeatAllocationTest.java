package com.algomind.leetcode.cinemaseatallocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CinemaSeatAllocationTest {
    private final CinemaSeatAllocation cinemaSeatAllocation = new CinemaSeatAllocation();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCinemaSeatAllocation(int expected, int n, int[][] reservedSeat) {
        Assertions.assertEquals(expected, cinemaSeatAllocation.maxNumberOfFamilies(n, reservedSeat));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, 3, new int[][]{new int[]{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}),
                Arguments.of(2, 2, new int[][]{new int[]{2,1},{1,8},{2,6}}),
                Arguments.of(4, 4, new int[][]{new int[]{4,3},{1,4},{4,6},{1,7}}),
                Arguments.of(4, 2, new int[][]{new int[]{1,1}}),
                Arguments.of(3, 2, new int[][]{new int[]{1,4}})
        );
    }
}