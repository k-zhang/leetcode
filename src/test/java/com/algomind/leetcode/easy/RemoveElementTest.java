package com.algomind.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveElementTest {
    private final RemoveElement removeElement = new RemoveElement();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[] input, int val) {
        Assertions.assertEquals(expected, removeElement.removeElement(input, val));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, new int[]{},3),
                Arguments.of(1, new int[]{1},3),
                Arguments.of(0, new int[]{3},3),
                Arguments.of(1, new int[]{1,1,2},1),
                Arguments.of(2, new int[]{1,1,2},2),
                Arguments.of(2, new int[]{3,2,2,3}, 3),
                Arguments.of(5, new int[]{0,1,2,2,3,0,4,2}, 2),
                Arguments.of(11, new int[]{0,1,2,3,4,5,6,7,8,9,10},100)
        );
    }
}