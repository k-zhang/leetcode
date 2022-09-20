package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return List.of();
        var result = new ArrayList<List<Integer>>();
        search(root, 0, targetSum, new LinkedList<>(), result);
        return result;
    }

    private void search(TreeNode root, int sum, int targetSum, LinkedList<Integer> path, List<List<Integer>> result) {
        if(root.left == null && root.right == null && sum + root.val == targetSum) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.add(root.val);
        sum += root.val;

        if(root.left != null) search(root.left, sum, targetSum, path, result);
        if(root.right != null) search(root.right, sum, targetSum, path, result);

        path.removeLast();
    }
}
