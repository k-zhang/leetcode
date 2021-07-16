package com.algomind.leetcode.rangeaddition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RangeAdditionTest {
    private final RangeAddition solution = new RangeAddition();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int length, int[][] updates) {
        Assertions.assertArrayEquals(expected, solution.getModifiedArray1(length, updates));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{-2,0,3,5,3}, 5, new int[][]{{1,3,2},{2,4,3},{0,2,-2}}),
                Arguments.of(new int[]{0,-4,2,2,2,4,4,-4,-4,-4}, 10, new int[][]{{2,4,6},{5,6,8},{1,9,-4}})
        );
    }
}