package com.algomind.leetcode.symmetrictree;

import com.algomind.leetcode.common.TreeNode;

//DFS
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null || root.left.val != root.right.val) return false;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
