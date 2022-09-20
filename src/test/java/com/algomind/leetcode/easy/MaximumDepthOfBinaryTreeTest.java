package com.algomind.leetcode.easy;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumDepthOfBinaryTreeTest {
    private final MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, Integer[] treeArray) {
        TreeNode tree = TreeCreation.constructTree(treeArray);
        Assertions.assertEquals(expected, solution.maxDepth(tree));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(1, new Integer[]{3}),
            Arguments.of(3, new Integer[]{3,9,20,null,null,15,7}),
            Arguments.of(2, new Integer[]{1,null,2}),
            Arguments.of(0, new Integer[]{}),
            Arguments.of(1, new Integer[]{0}),
            Arguments.of(4, new Integer[]{1,null,2,3,null,null,4})
        );
    }
}