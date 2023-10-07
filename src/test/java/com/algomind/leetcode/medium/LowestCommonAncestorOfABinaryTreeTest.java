package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LowestCommonAncestorOfABinaryTreeTest {
    private final LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, Integer[] tree, int p, int q) {
        TreeNode root = TreeCreation.constructTree(tree);
        TreeNode lca = solution.lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));

        Assertions.assertEquals(expected, lca.val);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(3, new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, 5, 1),
            Arguments.of(5, new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, 5, 4),
            Arguments.of(3, new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, 5, 8),
            Arguments.of(1, new Integer[]{1,2}, 1, 2),
            Arguments.of(2, new Integer[]{2,null,1}, 1, 2),
            Arguments.of(6, new Integer[]{6,2,8,0,4,7,9,null,null,3,5}, 2, 8),
            Arguments.of(2, new Integer[]{6,2,8,0,4,7,9,null,null,3,5}, 2, 4),
            Arguments.of(2, new Integer[]{2,1}, 2, 1)
        );
    }
}