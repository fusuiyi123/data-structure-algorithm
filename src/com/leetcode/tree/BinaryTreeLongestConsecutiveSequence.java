package com.leetcode.tree;

public class BinaryTreeLongestConsecutiveSequence {

    // 298. Binary Tree Longest Consecutive Sequence
    int res = 1;
    public int longestConsecutive(TreeNode root) {

        if (root == null) return 0;
        dfs(root, 0, root.val);
        return res;
    }

    private void dfs(TreeNode root, int curr, int target) {
        if (root == null) return;
        if (root.val == target) {
            curr++;;
        } else {
            curr = 1;
        }
        res = Math.max(res, curr);
        dfs(root.left, curr, root.val + 1);
        dfs(root.right, curr, root.val + 1);
    }

    // 549. Binary Tree Longest Consecutive Sequence II
    int maxval = 1;
    public int longestConsecutive2(TreeNode root) {
        if (root == null) return 0;
        longestPath(root);
        return maxval;
    }

    private int[] longestPath(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                dcr = l[1] + 1;
            }
            if (root.val == root.left.val - 1) {
                inr = l[0] + 1;
            }
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, r[1] + 1);
            }
            if (root.val == root.right.val - 1) {
                inr = Math.max(inr, r[0] + 1);
            }
        }
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[]{inr, dcr};
    }
}
