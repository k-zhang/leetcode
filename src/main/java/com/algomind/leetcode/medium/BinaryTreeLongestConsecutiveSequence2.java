package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence2 {
    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;

        doSearch(root);
        return maxLength;
    }

    private int[] doSearch(TreeNode root) {
        int inc = 1, dec = 1;

        if(root.left != null) {
            int[] leftResult = doSearch(root.left);
            if(root.left.val == root.val + 1) {
                inc = leftResult[0] + 1;
            }else if(root.left.val == root.val - 1) {
                dec = leftResult[1] + 1;
            }
        }

        if(root.right != null) {
            int[] rightResult = doSearch(root.right);
            if(root.right.val == root.val + 1) {
                inc = Math.max(inc, rightResult[0] + 1);
            }else if(root.right.val == root.val - 1) {
                dec = Math.max(dec, rightResult[1] + 1);
            }
        }

        maxLength = Math.max(maxLength, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
