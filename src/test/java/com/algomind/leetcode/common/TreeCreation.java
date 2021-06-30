package com.algomind.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class TreeCreation {
    public static TreeNode constructTree(Integer[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) {
            if(nums[0] == null) throw new IllegalArgumentException("Cannot have one single null as input.");
            return new TreeNode(nums[0]);
        }

        List<TreeNode> tree = new ArrayList<>();
        for(var num : nums ) {
            TreeNode node = num != null ? new TreeNode(num) : null;
            tree.add(node);
        }

        int index = 0, search = 1;
        while(search < tree.size()) {
            TreeNode node = tree.get(index);
            if(node != null) {
                node.left = tree.get(search++);
                if(search < tree.size()) node.right = tree.get(search++);
            }
            index ++;
        }

        return tree.get(0);
    }
}
