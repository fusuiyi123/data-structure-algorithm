package com.dsalglc.tree;

import java.util.LinkedList;
import java.util.Queue;

// 958. Check Completeness of a Binary Tree
public class CompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (flag) return false;
                queue.offer(node.left);
            } else {
                flag = true;
            }
            if (node.right != null) {
                if (flag) return false;
                queue.offer(node.right);
            } else {
                flag = true;
            }
        }
        return true;

    }
}
