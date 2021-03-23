package com.algomind.leetcode.partitionarrayformaximumsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PartitionArrayForMaximumSumTest {
    private final PartitionArrayForMaximumSum partitionArrayForMaximumSum = new PartitionArrayForMaximumSum();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testPartitionArrayForMaximumSum(int expected, int[] input, int k) {
        Assertions.assertEquals(expected, partitionArrayForMaximumSum.maxSumAfterPartitioning(input, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(84, new int[]{1,15,7,9,2,5,10}, 3),
                Arguments.of(83, new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4),
                Arguments.of(1, new int[]{1}, 1)
        );
    }
}