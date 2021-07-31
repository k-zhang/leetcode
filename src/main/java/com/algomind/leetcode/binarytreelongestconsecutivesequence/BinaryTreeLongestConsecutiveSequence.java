package com.algomind.leetcode.binarytreelongestconsecutivesequence;

import com.algomind.leetcode.common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        doSearch(root);
        return maxLength;
    }

    private int doSearch(TreeNode root) {
        if(root == null) return 0;

        int leftResult = doSearch(root.left) + 1;
        int rightResult = doSearch(root.right) + 1;

        if(root.left != null && root.left.val - root.val != 1 ) {
            leftResult = 1;
        }

        if(root.right != null && root.right.val - root.val != 1 ) {
            rightResult = 1;
        }

        int length = Math.max(leftResult, rightResult);
        maxLength = Math.max(length, maxLength);
        return length;
    }
}
