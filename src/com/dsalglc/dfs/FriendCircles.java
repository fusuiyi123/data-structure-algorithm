package com.dsalglc.dfs;

import java.util.Arrays;

public class FriendCircles {

    // 547. Friend Circles
    // Time: O(n^2), Space: O(n)
    public int findCircleNum(int[][] M) {
        int res = 0;
        int[] visited = new int[M.length];
        Arrays.fill(visited, 0);
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
