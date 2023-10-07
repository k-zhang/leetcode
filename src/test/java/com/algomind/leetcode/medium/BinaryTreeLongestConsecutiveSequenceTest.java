package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinaryTreeLongestConsecutiveSequenceTest {
    private final BinaryTreeLongestConsecutiveSequence solution = new BinaryTreeLongestConsecutiveSequence();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, Integer[] nums) {
        TreeNode tree = TreeCreation.constructTree(nums);
        Assertions.assertEquals(expected, solution.longestConsecutive(tree));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new Integer[]{1,null,3,2,4,null,null,null,5}),
            Arguments.of(2, new Integer[]{2,null,3,2,null,1}),
            Arguments.of(1, new Integer[]{2})
        );
    }
}