package com.algomind.leetcode.threesum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ThreeSumTest {
    private final ThreeSum threeSum = new ThreeSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testThreeSum(List<List<Integer>> expected, int[] nums) {
        List<List<Integer>> result = threeSum.threeSum(nums);
        Assertions.assertEquals(expected.size(), result.size());

        int matched = 0;
        for (List<Integer> threeNumbers : expected) {
            for (int j = 0; j < result.size(); j++) {
                List<Integer> resultThreeNumbers = expected.get(j);
                if (threeNumbers.containsAll(resultThreeNumbers) && resultThreeNumbers.containsAll(threeNumbers)) {
                    matched++;
                }
            }
        }

        Assertions.assertEquals(expected.size(), matched);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testThreeSum1(List<List<Integer>> expected, int[] nums) {
        List<List<Integer>> result = threeSum.threeSum1(nums);
        Assertions.assertEquals(expected.size(), result.size());

        int matched = 0;
        for (List<Integer> threeNumbers : expected) {
            for (int j = 0; j < result.size(); j++) {
                List<Integer> resultThreeNumbers = expected.get(j);
                if (threeNumbers.containsAll(resultThreeNumbers) && resultThreeNumbers.containsAll(threeNumbers)) {
                    matched++;
                }
            }
        }

        Assertions.assertEquals(expected.size(), matched);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(List.of(List.of(-1,-1,2), List.of(-1,0,1)), new int[]{-1,0,1,2,-1,-4}),
            Arguments.of(List.of(List.of(-2,0,2)), new int[]{0,-4,-1,-4,-2,-3,2}),
            Arguments.of(List.of(List.of(-1,-1,2), List.of(-1,0,1), List.of(-4,3,1)), new int[]{-1,0,1,2,-1,-4,3}),
            Arguments.of(List.of(List.of(-1,-1,2), List.of(-1,0,1), List.of(-4,3,1)), new int[]{-1,0,1,2,0,-1,-4,3}),
            Arguments.of(List.of(List.of(-1,-1,2), List.of(-1,0,1), List.of(-4,3,1), List.of(0,0,0)), new int[]{-1,0,1,2,0,-1,0,-4,3}),
            Arguments.of(List.of(List.of(-4,0,4),List.of(-4,1,3),List.of(-3,-1,4),List.of(-3,0,3),List.of(-3,1,2),List.of(-2,-1,3),List.of(-2,0,2),List.of(-1,-1,2),List.of(-1,0,1)), new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}),
            Arguments.of(List.of(), new int[]{2,5,1,2,1,4,3}),
            Arguments.of(List.of(), new int[]{-2,-5,-1,-2,-1,-4,-3}),
            Arguments.of(List.of(), new int[]{}),
            Arguments.of(List.of(), new int[]{0})
        );
    }
}