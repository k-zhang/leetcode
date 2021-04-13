package com.algomind.leetcode.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        var stack = new Stack<TreeNode>();
        var current = root;

        var result = new ArrayList<Integer>();

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}
