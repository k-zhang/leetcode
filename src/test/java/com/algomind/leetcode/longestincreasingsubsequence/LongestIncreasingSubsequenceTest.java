package com.algomind.leetcode.longestincreasingsubsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int result, int[] nums) {
        Assertions.assertEquals(result, solution.lengthOfLIS1(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, new int[]{0,3,1,6,2,2,7}),
                Arguments.of(4, new int[]{10,9,2,5,3,7,101,18}),
                Arguments.of(4, new int[]{0,1,0,3,2,3}),
                Arguments.of(1, new int[]{7,7,7,7,7,7,7}),
                Arguments.of(1, new int[]{5}),
                Arguments.of(3, new int[]{4,10,4,3,8,9}),
                Arguments.of(6, new int[]{1,3,6,7,9,4,10,5,6}),
                Arguments.of(6, new int[]{3,5,6,2,5,4,19,5,6,7,12})
        );
    }
}