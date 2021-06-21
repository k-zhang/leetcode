package com.algomind.leetcode.pascalstriangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PascalsTriangleTest {
    private final PascalsTriangle pascalsTriangle = new PascalsTriangle();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(List<List<Integer>> expected, int numRows) {
        var result = pascalsTriangle.generate(numRows);

        for(int i = 0 ; i < expected.size() ; i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(List.of(List.of(1)), 1),
            Arguments.of(List.of(List.of(1),List.of(1,1),List.of(1,2,1),List.of(1,3,3,1),List.of(1,4,6,4,1)), 5),
            Arguments.of(List.of(List.of(1),List.of(1,1),List.of(1,2,1),List.of(1,3,3,1),List.of(1,4,6,4,1),List.of(1,5,10,10,5,1)), 6)
        );
    }
}