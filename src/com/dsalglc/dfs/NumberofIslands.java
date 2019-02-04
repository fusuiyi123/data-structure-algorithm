package com.dsalglc.dfs;

public class NumberofIslands {

    // 200. Number of Islands
    private int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;

    }

    public void dfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int dr = dir[0], dc = dir[1];
            if (r + dr < 0 || r + dr >= grid.length || c + dc < 0 || c + dc >= grid[0].length) continue;
            dfs(grid, r + dr, c + dc);
        }
    }
}
