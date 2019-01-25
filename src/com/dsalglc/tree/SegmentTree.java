package com.dsalglc.tree;

// 307. Range Sum Query - Mutable segment tree
public class SegmentTree {
    class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left;
        TreeNode right;
        public TreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    private TreeNode root;
    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);

    }

    private TreeNode buildTree(int[] nums, int i, int j) {
        if (nums.length == 0 || i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(i, j, nums[i]);
        }
        int mid = i + (j - i) / 2;
        TreeNode current = new TreeNode(i, j);
        current.left = buildTree(nums, i, mid);
        current.right = buildTree(nums, mid + 1, j);
        current.sum = current.left.sum + current.right.sum;
        return current;
    }

    private int sumRangeHelper(TreeNode root, int i, int j) {
        if (root == null || i > root.end || j < root.start || i > j) {
            return 0;
        }
        if (i <= root.start && j >= root.end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int result = sumRangeHelper(root.left, i, Math.min(mid, j)) + sumRangeHelper(root.right, Math.max(mid+1, i), j);
        return result;
    }

    private void updateHelper(TreeNode root, int i, int val) {
        if (root == null) return;
        if (root.start == root.end && root.start == i) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;

        if (i <= mid) {
            updateHelper(root.left, i, val);
        } else {
            updateHelper(root.right, i, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public void update(int i, int val) {
        updateHelper(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }
}
