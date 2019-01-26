package com.dsalglc.graph;

// union find
public class GraphValidTree {
    // 261. Graph Valid Tree
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge: edges) {
            int a = find(parent, edge[0]);
            int b = find(parent, edge[1]);
            if (a == b) {
                return false;
            }
            union(parent, a, b);
        }
        return true;
    }

    // quick union
    private void union(int[] parent, int a, int b) {
        parent[a] = b;
    }

    // find with path compression
    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
