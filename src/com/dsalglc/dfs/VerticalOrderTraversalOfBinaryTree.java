package com.dsalglc.dfs;
import com.dsalglc.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VerticalOrderTraversalOfBinaryTree {

    private List<int[]> list;

    // 987. Vertical Order Traversal of a Binary Tree
    // time: O(n*log(n)) space:
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) return a[1] - b[1];
                if (a[2] != b[2]) return a[2] - b[2];
                return a[0] - b[0];
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); ) {
            int j = i;
            while (j < list.size() && list.get(j)[1] == list.get(i)[1]) j++;
            List<Integer> temp = new ArrayList<>();
            for (int k = i; k < j; k++) {
                temp.add(list.get(k)[0]);
            }
            res.add(temp);
            i = j;
        }
        return res;
    }

    private void dfs(TreeNode node, int x, int y) {
        if (node == null) return;
        list.add(new int[]{node.val, x, y});
        dfs(node.left, x - 1, y + 1);
        dfs(node.right, x + 1, y + 1);
    }

}
