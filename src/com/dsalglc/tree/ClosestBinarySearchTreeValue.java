package com.dsalglc.tree;

public class ClosestBinarySearchTreeValue {

    // 270. Closest Binary Search Tree Value
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = root.val < target ? root.right : root.left;
        }
        return res;
    }

    public int closestValue1(TreeNode root, double target) {
        int val = root.val;
        TreeNode node = target < val ? root.left : root.right;
        if (node == null) {
            return val;
        }
        int val1 = closestValue1(node, target);
        return Math.abs(val - target) < Math.abs(val1 - target) ? val : val1;
    }
}
