package com.dsalglc.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    // 417. Pacific Atlantic Water Flow
    public List<int[]> pacificAtlantic(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific);
            dfs(matrix, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, pacific);
            dfs(matrix, m - 1, j, atlantic);
        }
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int r, int c, boolean[][] visited) {
        if (visited[r][c]) return;
        int m = matrix.length, n = matrix[0].length;
        visited[r][c] = true;
        if (r - 1 >= 0 && !visited[r-1][c] && matrix[r][c] <= matrix[r-1][c])
            dfs(matrix, r - 1, c, visited);
        if (r + 1 < m && !visited[r+1][c] && matrix[r][c] <= matrix[r+1][c])
            dfs(matrix, r + 1, c, visited);
        if (c - 1 >= 0 && !visited[r][c-1] && matrix[r][c] <= matrix[r][c-1])
            dfs(matrix, r, c - 1, visited);
        if (c + 1 < n && !visited[r][c+1] && matrix[r][c] <= matrix[r][c+1])
            dfs(matrix, r, c + 1, visited);
    }
}
