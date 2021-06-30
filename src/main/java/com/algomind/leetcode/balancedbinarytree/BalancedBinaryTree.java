package com.algomind.leetcode.balancedbinarytree;

import com.algomind.leetcode.common.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return dfs(root, 0) != -1;
    }

    private int dfs(TreeNode root, int depth) {
        if(root == null) return depth;

        int depthLeft = dfs(root.left, depth + 1);
        int depthRight = dfs(root.right, depth + 1);

        if(depthLeft == -1 || depthRight == -1) return -1;

        return Math.abs(depthLeft - depthRight) <= 1 ? Math.max(depthLeft, depthRight) : -1;
    }
}
