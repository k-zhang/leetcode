package com.algomind.leetcode.convertsortedarraytobinarysearchtree;

import com.algomind.leetcode.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binaryInsert(nums, 0, nums.length);
    }

    private TreeNode binaryInsert(int[] nums, int start, int end) {
        if(start == end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid != start) {
            root.left = binaryInsert(nums, start, mid);
        }

        if(mid != end) {
            root.right = binaryInsert(nums, mid + 1, end);
        }

        return root;
    }
}
