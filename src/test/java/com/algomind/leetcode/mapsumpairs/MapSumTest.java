package com.algomind.leetcode.mapsumpairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MapSumTest {
    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Integer[] expected, Operation[] operations) {
        var mapSum = new MapSum();

        Integer[] result = new Integer[operations.length];
        for(var i = 0 ; i < operations.length ; i ++) {
            var operation = operations[i];
            switch (operations[i].op) {
                case "insert" -> mapSum.insert(operation.word, operation.score);
                case "sum" -> result[i] = mapSum.sum(operation.word);
            }
        }

        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new Integer[]{null, 3, null , 5},
                                                   new Operation[]{new Operation("insert", "apple", 3),
                                                   new Operation("sum", "ap"),
                                                   new Operation("insert", "app", 2),
                                                   new Operation("sum", "ap")})
        );
    }

    private static class Operation {
        String op;
        String word;
        Integer score;

        public Operation(String op, String word, Integer score) {
            this.op = op;
            this.word = word;
            this.score = score;
        }

        public Operation(String op, String word) {
            this.op = op;
            this.word = word;
        }
    }
}