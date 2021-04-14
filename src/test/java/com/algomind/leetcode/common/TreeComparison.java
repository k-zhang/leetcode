package com.algomind.leetcode.common;

public class TreeComparison {
    public static boolean areIdenticalTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        if(root1 != null  && root2 != null) {
            return ((root1.val.equals(root2.val)) &&
                    (areIdenticalTrees(root1.left, root2.left)) &&
                    (areIdenticalTrees(root1.right, root2.right)));
        }

        return false;
    }
}
