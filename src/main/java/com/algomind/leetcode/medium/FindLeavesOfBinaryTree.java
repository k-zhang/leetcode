package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    //Recursive
    public List<List<Integer>> findLeaves(TreeNode root) {
        var result = new ArrayList<List<Integer>>();

        while(root.left != null || root.right != null) {
            var leaves = new ArrayList<Integer>();
            doRemoveLeaves(leaves, root);
            result.add(leaves);
        }

        result.add(List.of(root.val));

        return result;
    }

    private boolean doRemoveLeaves(List<Integer> leaves, TreeNode root) {
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return true;
        }

        if(root.left != null) {
            boolean isLeftLeaf = doRemoveLeaves(leaves, root.left);
            if (isLeftLeaf) root.left = null;
        }

        if(root.right != null) {
            boolean isRightLeaf = doRemoveLeaves(leaves, root.right);
            if (isRightLeaf) root.right = null;
        }

        return false;
    }
}
