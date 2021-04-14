package com.algomind.leetcode.common;

import java.util.*;
import java.util.stream.Collectors;

public class TreeCreation {
    public static TreeNode constructTree(Integer[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) {
            if(nums[0] == null) throw new IllegalArgumentException("Cannot have one single null as input.");
            return new TreeNode(nums[0]);
        }

        List<TreeNode> tree = Arrays.stream(nums).map(TreeNode::new).collect(Collectors.toList());

        int index = 0, search = 1;
        while(search < tree.size()) {
            TreeNode node = tree.get(index);
            if(node.val != null) {
                node.left = tree.get(search++);
                if(search < tree.size()) node.right = tree.get(search++);
            }
            index ++;
        }

        cleanNull(tree.get(0));

        return tree.get(0);
    }

    private static void cleanNull(TreeNode treeNode) {
        if(treeNode == null) return;

        if(treeNode.left != null && treeNode.left.val == null) treeNode.left = null;
        if(treeNode.right != null && treeNode.right.val == null) treeNode.right = null;

        if(treeNode.left != null) cleanNull(treeNode.left);
        if(treeNode.right != null) cleanNull(treeNode.right);
    }
}
