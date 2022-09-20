package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.medium.NArrayTreeLevelOrderTraversal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NArrayTreeLevelOrderTraversalTest {
    private final NArrayTreeLevelOrderTraversal solution = new NArrayTreeLevelOrderTraversal();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, Integer[] treeArray) {
        var tree = TreeCreation.constructNaryTree(treeArray);
        var result = solution.levelOrder(tree);

        var arrayResult = new int[result.size()][];
        for(int i = 0 ; i < result.size() ; i ++) {
            arrayResult[i] = result.get(i).stream().mapToInt(n -> n).toArray();
        }

        Assertions.assertArrayEquals(expected, arrayResult);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[][]{{1},{3,2,4},{5,6}}, new Integer[]{1,null,3,2,4,null,5,6}),
            Arguments.of(new int[][]{{1},{2,3,4,5},{6,7,8,9,10},{11,12,13},{14}}, new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14}),
            Arguments.of(new int[][]{{1}}, new Integer[]{1}),
            Arguments.of(new int[][]{}, new Integer[]{})
        );
    }
}