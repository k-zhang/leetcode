package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BinaryTreeInOrderTraversalTest {
    private final BinaryTreeInOrderTraversal binaryTreeInOrderTraversal = new BinaryTreeInOrderTraversal();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCreateBinaryTreeInOrder(Integer[] expected, Integer[] nums) {
        TreeNode tree = TreeCreation.constructTree(nums);
        List<Integer> result = binaryTreeInOrderTraversal.inorderTraversal(tree);

        Assertions.assertArrayEquals(expected, result.toArray(new Integer[0]));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new Integer[]{8,4,2,5,1,6,3,7}, new Integer[]{1,2,3,4,5,6,7,8}),
                Arguments.of(new Integer[]{1,6,3,7,2,8,5}, new Integer[]{1,null,2,3,5,6,7,8}),
                Arguments.of(new Integer[]{1,6,8,3,7,2}, new Integer[]{1,null,2,3,null,6,7,null,8})
        );
    }
}