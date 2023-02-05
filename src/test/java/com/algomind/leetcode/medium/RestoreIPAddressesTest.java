package com.algomind.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class RestoreIPAddressesTest {
    private final RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Set<String> expected, String s) {
        var result = restoreIPAddresses.restoreIpAddresses(s);
        Assertions.assertEquals(expected, new HashSet<>(result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(Set.of("255.255.11.135","255.255.111.35"), "25525511135"),
            Arguments.of(Set.of("0.0.0.0"), "0000"),
            Arguments.of(Set.of("0.1.0.1"), "0101"),
            Arguments.of(Set.of("1.0.0.10", "10.0.1.0"), "10010"),
            Arguments.of(Set.of("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"), "101023"),
            Arguments.of(Set.of(), "255")
        );
    }
}