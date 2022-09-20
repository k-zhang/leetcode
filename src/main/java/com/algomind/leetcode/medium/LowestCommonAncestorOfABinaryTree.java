package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if(left && right || ((left || right) && (root.val == p.val || root.val == q.val))) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
