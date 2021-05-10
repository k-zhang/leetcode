package com.algomind.leetcode.rotatearray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RotateArrayTest {
    private final RotateArray rotateArray = new RotateArray();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] nums, int k) {
        rotateArray.rotate2(nums, k);
        Assertions.assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{9,7,6,3,8}, new int[]{3,8,9,7,6}, 3),
                Arguments.of(new int[]{0,0,0}, new int[]{0,0,0}, 1),
                Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4}, 4),
                Arguments.of(new int[]{1}, new int[]{1}, 3),
                Arguments.of(new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6}, 0),
                Arguments.of(new int[]{2,3,4,5,6,7,8,9,10,1}, new int[]{1,2,3,4,5,6,7,8,9,10}, 99),
                Arguments.of(new int[]{-3,-4,-5,-6,-1,-2}, new int[]{-1,-2,-3,-4,-5,-6}, 10)
        );
    }
}
