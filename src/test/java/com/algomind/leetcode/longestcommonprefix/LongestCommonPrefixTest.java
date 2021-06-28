package com.algomind.leetcode.longestcommonprefix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestCommonPrefixTest {
    private final LongestCommonPrefix solution = new LongestCommonPrefix();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(String expected, String[] strs) {
        Assertions.assertEquals(expected, solution.longestCommonPrefix1(strs));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("fl", new String[]{"flower","flow","flight"}),
            Arguments.of("", new String[]{"dog","racecar","car"}),
            Arguments.of("dog", new String[]{"dog"}),
            Arguments.of("", new String[]{"dog","cat"}),
            Arguments.of("", new String[]{"dog",""}),
            Arguments.of("", new String[]{"",""}),
            Arguments.of("flower", new String[]{"flower","flower","flower","flower"})
        );
    }
}