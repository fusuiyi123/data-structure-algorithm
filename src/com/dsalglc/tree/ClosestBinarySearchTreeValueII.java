package com.dsalglc.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 272. Closest Binary Search Tree Value II
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        getPredecessor(root, target, pred);
        getSuccessor(root, target, succ);
        if (!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == succ.peek().val) {
            getNextPredecessor(pred);
        }

        while (k-- > 0) {
            if (pred.isEmpty()) {
                res.add(getNextSuccessor(succ));
            } else if (succ.isEmpty()) {
                res.add(getNextPredecessor(pred));
            } else {
                double predDiff = Math.abs(target - (double)pred.peek().val);
                double succDiff = Math.abs(target - (double)succ.peek().val);
                if (predDiff < succDiff) res.add(getNextPredecessor(pred));
                else res.add(getNextSuccessor(succ));
            }
        }
        return res;
    }

    private void getPredecessor(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            }
            if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private void getSuccessor(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            }
            if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int val = curr.val;
        curr = curr.left;
        while (curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return val;
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int val = curr.val;
        curr = curr.right;
        while (curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return val;
    }
}
