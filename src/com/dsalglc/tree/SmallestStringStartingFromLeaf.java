package com.dsalglc.tree;

import java.util.TreeSet;

public class SmallestStringStartingFromLeaf {
    // 988. Smallest String Starting From Leaf
    private TreeSet<String> treeSet = new TreeSet<>();
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return treeSet.first();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        char c = (char)(root.val + 'a');
        sb.append(c);
        if (root.left == null && root.right == null) {
            treeSet.add(sb.reverse().toString());
            sb.reverse();
        } else {
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
