package com.algomind.leetcode.twosum2inputarrayissorted;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoSum2InputArrayIsSortedTest {
    private final TwoSum2InputArrayIsSorted twoSum2InputArrayIsSorted = new TwoSum2InputArrayIsSorted();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] numbers, int target) {
        Assertions.assertArrayEquals(expected, twoSum2InputArrayIsSorted.twoSum(numbers, target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1,2}, new int[]{2,7,11,15}, 9),
                Arguments.of(new int[]{1,3}, new int[]{2,3,4}, 6),
                Arguments.of(new int[]{1,2}, new int[]{-1,0}, -1),
                Arguments.of(new int[]{1,2}, new int[]{2,2,2,2,2}, 4),
                Arguments.of(new int[]{1,5}, new int[]{2,2,2,2,3}, 5)
        );
    }
}