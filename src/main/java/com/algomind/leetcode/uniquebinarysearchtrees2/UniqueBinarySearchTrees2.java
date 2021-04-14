package com.algomind.leetcode.uniquebinarysearchtrees2;

import com.algomind.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    // DP
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return List.of();

        var dp = new ArrayList<List<TreeNode>>();
        dp.add(0, new ArrayList<>());
        dp.get(0).add(null);

        for(int len = 1 ; len <= n ; len++) {
            dp.add(len, new ArrayList<>());

            for(int root = 1 ; root <= len ; root ++) {
                int leftSize =  root - 1;
                int rightSize = len - root;

                for (TreeNode leftBranch : dp.get(leftSize)) {
                    for (TreeNode rightBranch : dp.get(rightSize)) {
                        TreeNode treeNode = new TreeNode(root);
                        treeNode.left = leftBranch;
                        treeNode.right = elevate(rightBranch, root);
                        dp.get(len).add(treeNode);
                    }
                }
            }
        }

        return dp.get(n);
    }

    private TreeNode elevate(TreeNode branch, int increment) {
        if(branch == null) return null;
        TreeNode treeNode = new TreeNode(branch.val + increment);
        treeNode.left = elevate(branch.left, increment);
        treeNode.right = elevate(branch.right, increment);
        return treeNode;
    }

    // Recursive
    public List<TreeNode> generateTreesRecursive(int n) {
        if(n == 0) return List.of();
        return doRecursive(1, n);
    }

    private List<TreeNode> doRecursive(int start, int end) {
        var allTrees = new ArrayList<TreeNode>();

        if(start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for(int i = start ; i <= end ; i ++) {
            var leftTrees = doRecursive(start, i - 1);
            var rightTrees = doRecursive(i + 1, end);

            for(TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    allTrees.add(treeNode);
                }
            }
        }

        return allTrees;
    }
}
