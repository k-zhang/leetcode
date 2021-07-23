package com.algomind.leetcode.binarytreepruning;

import com.algomind.leetcode.common.TreeComparison;
import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinaryTreePruningTest {
    private final BinaryTreePruning solution = new BinaryTreePruning();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Integer[] expected, Integer[] nums) {
        TreeNode tree = TreeCreation.constructTree(nums);
        TreeNode result = solution.pruneTree(tree);

        TreeNode expectedTree = TreeCreation.constructTree(expected);

        Assertions.assertTrue(TreeComparison.areIdenticalTrees(expectedTree, result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new Integer[]{1,null,0,null,1}, new Integer[]{1,null,0,0,1}),
            Arguments.of(new Integer[]{1,null,1,null,1}, new Integer[]{1,0,1,0,0,0,1}),
            Arguments.of(new Integer[]{1,1,0,1,1,null,1}, new Integer[]{1,1,0,1,1,0,1,0}),
            Arguments.of(new Integer[]{1}, new Integer[]{1}),
            Arguments.of(new Integer[]{0,1}, new Integer[]{0,1}),
            Arguments.of(new Integer[]{0,null,1}, new Integer[]{0,null,1}),
            Arguments.of(new Integer[]{}, new Integer[]{0})
        );
    }
}