package com.dsalglc.graph;

public class FriendCircles {

    // 547. Friend Circles
    public int findCircleNum(int[][] M) {
        int N = M.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                    int a = uf.find(i);
                    int b = uf.find(j);
                    uf.union(a, b);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (uf.parent[i] == i) {
                res++;
            }
        }
        return res;
    }
}
