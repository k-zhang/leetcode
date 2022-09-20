package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ShortestDistanceToTargetColorTest {
    private final ShortestDistanceToTargetColor shortestDistanceToTargetColor = new ShortestDistanceToTargetColor();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testThreeSumClosest(int[] expected, int[] colors, int[][] queries) {
        List<Integer> result = shortestDistanceToTargetColor.shortestDistanceColor(colors, queries);
        Assertions.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{3,0,3}, new int[]{1,1,2,1,3,2,2,3,3}, new int[][]{{1,3},{2,2},{6,1}}),
            Arguments.of(new int[]{0,0,0}, new int[]{1,1,1,1,1,1,1,1,1}, new int[][]{{1,1},{2,1},{6,1}}),
            Arguments.of(new int[]{8,8}, new int[]{1,2,3,4,5,6,7,8,9}, new int[][]{{0,9},{8,1}}),
            Arguments.of(new int[]{4,4}, new int[]{1,2,3,4,5,6,7,8,9}, new int[][]{{4,1},{4,9}}),
            Arguments.of(new int[]{4,4}, new int[]{1,2,3,4,5,6,7,8,9}, new int[][]{{0,5},{8,5}}),
            Arguments.of(new int[]{4}, new int[]{1,2,3,4,5,4,3,2,1}, new int[][]{{4,1}}),
            Arguments.of(new int[]{-1}, new int[]{1,2}, new int[][]{{0,3}})
        );
    }
}