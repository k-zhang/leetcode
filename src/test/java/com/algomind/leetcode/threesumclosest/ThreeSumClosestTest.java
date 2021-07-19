package com.algomind.leetcode.threesumclosest;

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
                Arguments.of(2, new int[]{-1,0,1,1,55}, 3)
        );
    }
}