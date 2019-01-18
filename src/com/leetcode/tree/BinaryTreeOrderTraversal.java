package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102 Binary Tree Level Order Traversal
public class BinaryTreeOrderTraversal {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(tempList);

        }
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> currLevel = res.get(depth);
        currLevel.add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

}
