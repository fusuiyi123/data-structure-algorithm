package com.dsalglc.tree;

public class CountCompleteTreeNodes {
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    // 222. Count Complete Tree Nodes
    // Time: O(log(n)^2)
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 0) return 0;
        int res = 0;
        while (root != null) {
            if (height(root.right) == h - 1) {
                res += 1 << h;
                root = root.right;
            } else {
                res += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return res;

        /*

        int right = height(root.right);
        if (right == h - 1) {
            return 1 << h + countNodes(root.right);
        } else {
            return 1 << (h-1) + countNodes(root.left);
        }
        */
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + height(root.left);
    }
}
