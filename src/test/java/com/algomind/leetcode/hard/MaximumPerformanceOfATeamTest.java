package com.algomind.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumPerformanceOfATeamTest {
    private final MaximumPerformanceOfATeam solution = new MaximumPerformanceOfATeam();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int n, int[] speed, int[] efficiency, int k) {
        Assertions.assertEquals(expected, solution.maxPerformance(n, speed, efficiency, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(60, 6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 2),
                Arguments.of(68, 6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 3),
                Arguments.of(72, 6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 4)
        );
    }
}