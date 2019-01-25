package com.dsalglc.tree;

// 968. Binary Tree Cameras
public class BinaryTreeCameras {
    private int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) == 0 ? 1 : 0) + res;
    }

    // 0: leaf
    // 1: parent of leaf, with camera
    // 2: covered without camera
    private int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
