package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ThreeSumClosestTest {
    private final ThreeSumClosest solution = new ThreeSumClosest();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] nums, int target) {
        Assertions.assertEquals(expected, solution.threeSumClosest(nums, target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[]{-1,2,1,-4}, 1),
                Arguments.of(0, new int[]{}, 1),
                Arguments.of(6, new int[]{1,2,3,4}, 2),
                Arguments.of(3, new int[]{1,1,1,1}, 0),
                Arguments.of(0, new int[]{1,1}, 10),
                Arguments.of(2, new int[]{-1,0,1,1,55}, 3),
                Arguments.of(27, new int[]{-4,-7,-2,2,5,-2,1,9,3,9,4,9,-9,-3,7,4,1,0,8,5,-7,-7}, 29)
        );
    }
}