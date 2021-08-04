package com.algomind.leetcode.pathsum2;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PathSum2Test {
    private final PathSum2 solution = new PathSum2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, Integer[] root, int targetSum) {
        TreeNode tree = TreeCreation.constructTree(root);
        var result = solution.pathSum(tree, targetSum);

        var finalResult = new int[result.size()][];
        for(int i = 0 ; i < result.size() ; i ++) {
            var l = result.get(i);
            finalResult[i] = l.stream().mapToInt(n -> n).toArray();
        }

        Assertions.assertArrayEquals(expected, finalResult);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[][]{{5,4,11,2}, {5,8,4,5}}, new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}, 22),
                Arguments.of(new int[][]{{5,4,11,7}}, new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}, 27),
                Arguments.of(new int[][]{{5,8,13}}, new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}, 26),
                Arguments.of(new int[][]{}, new Integer[]{1,2,3}, 5),
                Arguments.of(new int[][]{}, new Integer[]{1,2}, 0),
                Arguments.of(new int[][]{}, new Integer[]{}, 1)
        );
    }
}