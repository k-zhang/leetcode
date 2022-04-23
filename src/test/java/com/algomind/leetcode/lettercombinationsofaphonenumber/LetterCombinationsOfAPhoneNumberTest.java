package com.algomind.leetcode.lettercombinationsofaphonenumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class LetterCombinationsOfAPhoneNumberTest {
    private final LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<String> expected, String digits) {
        var result = solution.letterCombinations(digits);
        Assertions.assertEquals(expected, new HashSet<>(result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(Set.of("ad","ae","af","bd","be","bf","cd","ce","cf"), "23"),
            Arguments.of(Set.of("aehl", "bfgk", "bfgl", "bdgk", "beil", "cfhk", "bdgl", "bfgj",
                    "cfhl", "aehk", "beij", "cdhk", "aehj", "bdgj", "beik", "cdhl", "cfhj", "cdhj",
                    "aegl", "aegk", "afil", "cfgl", "adik", "behk", "cdgl", "cfgj", "adij", "behl",
                    "cfgk", "aegj", "afik", "cdgj", "ceik", "adil", "afij", "behj", "cdgk", "ceil",
                    "ceij", "afhl", "afhk", "begl", "adhj", "begj", "bfik", "cehl", "begk", "bfil",
                    "adhl", "afhj", "bdik", "cehj", "adhk", "bdil", "bfij", "cehk", "bdij", "afgk",
                    "adgl", "afgj", "bfhl", "afgl", "aeij", "bdhl", "bfhj", "cegk", "cfil", "bfhk",
                    "cegl", "adgk", "aeil", "bdhj", "cdil", "cfij", "adgj", "aeik", "bdhk", "cegj",
                    "cfik", "cdij", "cdik"), "2345"),
            Arguments.of(Set.of("a", "b", "c"), "2"),
            Arguments.of(Set.of(), "")
        );
    }
}