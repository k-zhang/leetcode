package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MyCalendar1Test {
    private final MyCalendar1 myCalendar1 = new MyCalendar1();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean[] expected, int[][] event) {
        for(int i = 0 ; i < event.length ; i++) {
            Assertions.assertEquals(expected[i], myCalendar1.book(event[i][0], event[i][1]));
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new boolean[]{true, false, true}, new int[][]{{10,20},{15,25},{20,30}}),
                Arguments.of(new boolean[]{true, true, true}, new int[][]{{10,20},{20,25},{25,30}}),
                Arguments.of(new boolean[]{true, false, false}, new int[][]{{10,20},{10,20},{10,20}}),
                Arguments.of(new boolean[]{true, true, true}, new int[][]{{10,20},{5,10},{20,30}}),
                Arguments.of(new boolean[]{true, false}, new int[][]{{10,20},{15,17}}),
                Arguments.of(new boolean[]{true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false,false,false,false,true},
                        new int[][]{{97,100},{33,51},{89,100},{83,100},{75,92},{76,95},{19,30},{53,63},{8,23},{18,37},{87,100},{83,100},{54,67},{35,48},{58,75},{70,89},{13,32},{44,63},{51,62},{2,15}})
        );
    }
}