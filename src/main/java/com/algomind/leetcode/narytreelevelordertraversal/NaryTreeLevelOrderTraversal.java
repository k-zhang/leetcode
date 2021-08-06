package com.algomind.leetcode.narytreelevelordertraversal;

import com.algomind.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return List.of();
        }

        var result = new ArrayList<List<Integer>>();
        doSearch(List.of(root), result);
        return result;
    }

    private void doSearch(List<Node> levelNodes, List<List<Integer>> result) {
        if(levelNodes.isEmpty()) return;

        var levelResult = new ArrayList<Integer>();
        for(var node : levelNodes) {
            levelResult.add(node.val);
        }
        result.add(levelResult);

        var nextLevelNodes = new ArrayList<Node>();
        for(var node : levelNodes) {
            if(node.children != null) {
                nextLevelNodes.addAll(node.children);
            }
        }

        doSearch(nextLevelNodes, result);
    }
}
