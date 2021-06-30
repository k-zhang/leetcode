package com.algomind.leetcode.balancedbinarytree;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BalancedBinaryTreeTest {
    private final BalancedBinaryTree solution = new BalancedBinaryTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, Integer[] treeArray) {
        TreeNode tree = TreeCreation.constructTree(treeArray);
        Assertions.assertEquals(expected, solution.isBalanced(tree));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(true, new Integer[]{3,9,20,null,null,15,7}),
            Arguments.of(true, new Integer[]{3,9,20,null,null,null,7}),
            Arguments.of(false, new Integer[]{3,9,20,null,null,null,7,8,null}),
            Arguments.of(false, new Integer[]{1,2,2,3,3,null,null,4,4}),
            Arguments.of(true, new Integer[]{})
        );
    }
}