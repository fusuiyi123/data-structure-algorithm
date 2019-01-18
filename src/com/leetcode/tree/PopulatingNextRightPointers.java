package com.leetcode.tree;

// 116. Populating Next Right Pointers in Each Node
public class PopulatingNextRightPointers {
    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = root;
        while (curr.left != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode node = dummy;
            while (curr != null) {
                node.next = curr.left;
                node = node.next;
                node.next = curr.right;
                node = node.next;
                curr = curr.next;
            }
            curr = dummy.next;
        }
    }


}
