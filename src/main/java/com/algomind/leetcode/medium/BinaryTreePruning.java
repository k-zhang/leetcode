package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        boolean pruneRoot = prune(root);
        return pruneRoot ? null : root;
    }

    private boolean prune(TreeNode root) {
        if(root == null) return true;

        boolean pruneLeft = prune(root.left);
        boolean pruneRight = prune(root.right);

        if(pruneLeft && pruneRight && root.val == 0) return true;
        if(pruneLeft) root.left = null;
        if(pruneRight) root.right = null;
        return false;
    }
}
