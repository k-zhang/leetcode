package com.algomind.leetcode.easy;

import com.algomind.leetcode.common.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int level) {
        if(root == null) return level;

        level = level + 1;
        int levelLeft = dfs(root.left, level);
        int levelRight = dfs(root.right, level);

        return Math.max(levelLeft, levelRight);
    }
}
