package com.algomind.leetcode.findleavesofbinarytree;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FindLeavesOfBinaryTreeTest {
    private final FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testCreateBinaryTreeInOrder(int[][] expected, Integer[] nums) {
        TreeNode tree = TreeCreation.constructTree(nums);
        List<List<Integer>> result = solution.findLeaves(tree);

        Assertions.assertEquals(expected.length, result.size());

        for(int i = 0 ; i < expected.length ; i ++) {
            List<Integer> leaves = result.get(i);
            int[] leavesArray = leaves.stream().mapToInt(num -> num).toArray();
            Assertions.assertArrayEquals(expected[i], leavesArray);
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[][]{{4,5,3},{2},{1}}, new Integer[]{1,2,3,4,5}),
            Arguments.of(new int[][]{{4,5,6,7},{2,3},{1}}, new Integer[]{1,2,3,4,5,6,7}),
            Arguments.of(new int[][]{{2,4,5},{3},{1}}, new Integer[]{1,2,3,null,null,4,5}),
            Arguments.of(new int[][]{{4,5},{2},{1}}, new Integer[]{1,2,null,4,5}),
            Arguments.of(new int[][]{{1}}, new Integer[]{1})
        );
    }
}