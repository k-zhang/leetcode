package com.algomind.leetcode.minimumdepthofbinarytree;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumDepthOfBinaryTreeTest {
    private final MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCreateBinaryTreeInOrder(int expected, Integer[] nums) {
        TreeNode tree = TreeCreation.constructTree(nums);
        Assertions.assertEquals(expected, solution.minDepth(tree));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, new Integer[]{3,9,20,null,null,15,7}),
            Arguments.of(5, new Integer[]{2,null,3,null,4,null,5,null,6}),
            Arguments.of(2, new Integer[]{2,3,4,5,null,null,null,6,null,7,null}),
            Arguments.of(1, new Integer[]{1}),
            Arguments.of(2, new Integer[]{1,null,2}),
            Arguments.of(0, new Integer[]{})
        );
    }
}