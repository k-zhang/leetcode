package com.algomind.leetcode.easy;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SameTreeTest {
    private final SameTree solution = new SameTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, Integer[] pArray, Integer[] qArray) {
        TreeNode p = TreeCreation.constructTree(pArray);
        TreeNode q = TreeCreation.constructTree(qArray);
        Assertions.assertEquals(expected, solution.isSameTree(p, q));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new Integer[]{1,2,3}, new Integer[]{1,2,3}),
                Arguments.of(false, new Integer[]{1,2}, new Integer[]{1,null,2}),
                Arguments.of(false, new Integer[]{1,2,1}, new Integer[]{1,1,2}),
                Arguments.of(true, new Integer[]{}, new Integer[]{}),
                Arguments.of(true, new Integer[]{1}, new Integer[]{1}),
                Arguments.of(true, new Integer[]{1,2,3,4,5,6,7,8,9}, new Integer[]{1,2,3,4,5,6,7,8,9})
        );
    }
}