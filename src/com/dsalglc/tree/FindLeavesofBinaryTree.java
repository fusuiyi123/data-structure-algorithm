package com.dsalglc.tree;

import java.util.ArrayList;
import java.util.List;

// 366. Find Leaves of Binary Tree
public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null)
            return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int height = Math.max(left, right) + 1;
        if (res.size() < height) res.add(new ArrayList<>());
        res.get(height-1).add(root.val);
        return height;
    }

}
