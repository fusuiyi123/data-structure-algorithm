package com.dsalglc.tree;

public class LCA {
    private int count = 0;
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        System.out.println(count);
        return lca;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (lca != null) return false;
        if (root == null) return false;
        count++;
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (mid + left + right >= 2) lca = root;
        return (mid + right + left) > 0;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}

