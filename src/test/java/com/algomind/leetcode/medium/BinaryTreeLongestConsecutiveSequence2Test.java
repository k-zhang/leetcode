package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinaryTreeLongestConsecutiveSequence2Test {
    private final BinaryTreeLongestConsecutiveSequence2 solution = new BinaryTreeLongestConsecutiveSequence2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, Integer[] nums) {
        TreeNode tree = TreeCreation.constructTree(nums);
        Assertions.assertEquals(expected, solution.longestConsecutive(tree));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, new Integer[]{1,2,3}),
            Arguments.of(3, new Integer[]{2,1,3}),
            Arguments.of(8, new Integer[]{24,25,25,26,24,26,24,25,27,23,23,25,25,23,23,26,24,26,28,24,22,22,24,26,26,26,26,22,24,22,22,null,27,null,25,null,25,null,27,null,25,null,21,null,23,23,23,null,25,null,25,null,27,27,25,null,23,null,23,null,21,21,21})
        );
    }
}