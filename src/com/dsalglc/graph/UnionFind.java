package com.dsalglc.graph;

public class UnionFind {

    public int[] parent;

    public UnionFind(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    // quick union
    public void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    // find with path compression
    public int find(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}

