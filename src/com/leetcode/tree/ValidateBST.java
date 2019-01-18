package com.leetcode.tree;

import java.util.Stack;

public class ValidateBST {
    // 98 Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
