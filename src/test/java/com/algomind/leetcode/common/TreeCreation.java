package com.algomind.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class TreeCreation {
    // Null is required for non-null parent node. If parent node is null, then null should not be in the array.
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

    public static Node constructNaryTree(Integer[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) {
            if(nums[0] == null) throw new IllegalArgumentException("Cannot have one single null as input.");
            return new Node(nums[0]);
        }

        List<Node> tree = new ArrayList<>();
        for(var num : nums ) {
            Node node = num != null ? new Node(num, new ArrayList<>()) : null;
            tree.add(node);
        }

        Node current = tree.get(0);;

        int index = 2, curIndex = 1;

        while(index < tree.size()) {
            while(index < tree.size() && tree.get(index) != null) {
                current.children.add(tree.get(index));
                index ++;
            }

            if(index == tree.size()) break;

            while(tree.get(++curIndex) == null) {}
            current = tree.get(curIndex);

            index ++;
        }

        return tree.get(0);
    }
}
