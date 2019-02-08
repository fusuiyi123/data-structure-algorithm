package com.dsalglc.graph;

// union find
public class GraphValidTree {
    // 261. Graph Valid Tree
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            int a = uf.find(edge[0]);
            int b = uf.find(edge[1]);
            if (a == b) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        return true;
    }

}
