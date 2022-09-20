package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GenerateParenthesesTest {
    private final GenerateParentheses generateParentheses = new GenerateParentheses();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<String> expected, int n) {
        var result = generateParentheses.generateParenthesis(n);
        Assertions.assertEquals(expected.stream().sorted().collect(Collectors.toList()), result.stream().sorted().collect(Collectors.toList()));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(Set.of("()"), 1),
                Arguments.of(Set.of("()()","(())"), 2),
                Arguments.of(Set.of("((()))","(()())","(())()","()(())","()()()"), 3),
                Arguments.of(Set.of("(((())))","((()()))","((())())","((()))()","(()(()))"
                        ,"(()()())","(()())()","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()","(())(())"), 4)
        );
    }
}