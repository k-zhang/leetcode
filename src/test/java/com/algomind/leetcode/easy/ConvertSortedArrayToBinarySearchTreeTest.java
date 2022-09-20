package com.algomind.leetcode.easy;

import com.algomind.leetcode.common.TreeComparison;
import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ConvertSortedArrayToBinarySearchTreeTest {
    private final ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCreateBinaryTreeInOrder(Integer[] expected, int[] nums) {
        TreeNode expectedTree = TreeCreation.constructTree(expected);
        Assertions.assertTrue(TreeComparison.areIdenticalTrees(expectedTree, solution.sortedArrayToBST(nums)));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new Integer[]{0,-3,9,-10,null,5}, new int[]{-10,-3,0,5,9}),
            Arguments.of(new Integer[]{3,1}, new int[]{1,3}),
            Arguments.of(new Integer[]{1}, new int[]{1}),
            Arguments.of(new Integer[]{3,1,5,0,2,4}, new int[]{0,1,2,3,4,5})
        );
    }
}