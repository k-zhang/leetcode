package com.algomind.leetcode.uniquebinarysearchtrees2;

import com.algomind.leetcode.common.TreeComparison;
import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class UniqueBinarySearchTrees2Test {
    private final UniqueBinarySearchTrees2 uniqueBinarySearchTrees2 = new UniqueBinarySearchTrees2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(Integer[][] expected, int input) {
        List<TreeNode> result = uniqueBinarySearchTrees2.generateTrees(input);

        Assertions.assertEquals(expected.length, result.size());

        List<TreeNode> expectedResults = new ArrayList<>();
        for (Integer[] integers : expected) {
            TreeNode tree = TreeCreation.constructTree(integers);
            expectedResults.add(tree);
        }

        for(TreeNode res : result) {
            boolean found = false;
            for(TreeNode exp : expectedResults) {
                if(TreeComparison.areIdenticalTrees(res, exp)) {
                    found = true;
                    break;
                }
            }

            if(!found) Assertions.fail(res.toString());
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testRecursive(Integer[][] expected, int input) {
        List<TreeNode> result = uniqueBinarySearchTrees2.generateTreesRecursive(input);

        Assertions.assertEquals(expected.length, result.size());

        List<TreeNode> expectedResults = new ArrayList<>();
        for (Integer[] integers : expected) {
            TreeNode tree = TreeCreation.constructTree(integers);
            expectedResults.add(tree);
        }

        for(TreeNode res : result) {
            boolean found = false;
            for(TreeNode exp : expectedResults) {
                if(TreeComparison.areIdenticalTrees(res, exp)) {
                    found = true;
                    break;
                }
            }

            if(!found) Assertions.fail(res.toString());
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new Integer[][]{
                        new Integer[]{1,null,2,null,3},
                        new Integer[]{1,null,3,2},
                        new Integer[]{2,1,3},
                        new Integer[]{3,1,null,null,2},
                        new Integer[]{3,2,null,1}},
                        3),
                Arguments.of(new Integer[][]{new Integer[]{1}}, 1),
                Arguments.of(new Integer[][]{}, 0)
        );
    }
}