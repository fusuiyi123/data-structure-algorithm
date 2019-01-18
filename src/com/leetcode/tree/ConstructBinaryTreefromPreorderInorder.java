package com.leetcode.tree;


// 105. Construct Binary Tree from Preorder and Inorder Traversal
public class ConstructBinaryTreefromPreorderInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = build(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = build(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
