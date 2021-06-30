package com.algomind.leetcode.symmetrictree;

import com.algomind.leetcode.common.TreeCreation;
import com.algomind.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SymmetricTreeTest {
    private final SymmetricTree solution = new SymmetricTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(boolean expected, Integer[] treeArray) {
        TreeNode tree = TreeCreation.constructTree(treeArray);
        Assertions.assertEquals(expected, solution.isSymmetric(tree));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(true, new Integer[]{1,2,2,3,4,4,3}),
                Arguments.of(false, new Integer[]{1,2,2,null,3,null,3}),
                Arguments.of(false, new Integer[]{1,0})
        );
    }
}