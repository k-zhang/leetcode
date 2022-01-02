package com.algomind.leetcode.pairofsongswithtotaldurationdivisibleby60;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PairsOfSongsWithTotalDurationsDivisibleBy60Test {
    private final PairsOfSongsWithTotalDurationsDivisibleBy60 solution = new PairsOfSongsWithTotalDurationsDivisibleBy60();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testNumberOfCornerRectangles(int expected, int[] nums) {
        Assertions.assertEquals(expected, solution.numPairsDivisibleBy60(nums));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, new int[]{30,20,150,100,40}),
                Arguments.of(3, new int[]{60,60,60}),
                Arguments.of(0, new int[]{60}),
                Arguments.of(1, new int[]{60,60}),
                Arguments.of(1, new int[]{480,60}),
                Arguments.of(1, new int[]{480, 480}),
                Arguments.of(0, new int[]{480, 500}),
                Arguments.of(3, new int[]{480, 60, 60}),
                Arguments.of(4, new int[]{480, 60, 1, 60, 59}),
                Arguments.of(5, new int[]{480, 60, 1, 60, 59, 1}),
                Arguments.of(176, new int[]{283,338,207,325,321,166,9,303,344,299,156,443,309,281,264,353,244,369,99,
                        97,66,109,228,164,371,282,69,234,122,239,234,91,304,435,51,213,357,463,246,150,111,494,351,
                        234,145,343,122,361,53,290,373,435,302,287,279,290,122,154,70,72,225,209,65,370,25,253,175,
                        262,336,250,78,201,293,374,325,426,236,106,123,430,393,49,154,250,116,295,9,348,344,107,393,
                        310,424,281,292,466,401,297,13,52,191,414,302,75,155,280,114,388,358,418,475,429,69,465,118,
                        259,294,59,386,256,410,81,176,282,274,166,322,315,28,289,403,283,236,143,397,45,420,59,367,
                        154,19,308,55,484})
        );
    }
}