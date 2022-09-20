package com.algomind.leetcode.easy;

import com.algomind.leetcode.common.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return doMinDepth(root, 1, Integer.MAX_VALUE);
    }

    private int doMinDepth(TreeNode root, int currentDepth, int currentMin) {
        if(currentMin == currentDepth || (root.left == null && root.right == null)) return currentDepth;

        int minLeft = root.left == null ? Integer.MAX_VALUE : doMinDepth(root.left, currentDepth + 1, currentMin);
        int minRight = root.right == null ? Integer.MAX_VALUE : doMinDepth(root.right, currentDepth + 1, minLeft);

        return Math.min(minLeft, minRight);
    }

    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
