package com.algomind.leetcode.openthelock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OpenTheLockTest {
    private final OpenTheLock openTheLock = new OpenTheLock();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, String[] deadEnd, String target){
        Assertions.assertEquals(expected, openTheLock.openLock(deadEnd, target));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(6, new String[]{"0201","0101","0102","1212","2002"}, "0202"),
                Arguments.of(1, new String[]{"8888"}, "0009"),
                Arguments.of(-1, new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"),
                Arguments.of(-1, new String[]{"0000"}, "8888")
        );
    }
}