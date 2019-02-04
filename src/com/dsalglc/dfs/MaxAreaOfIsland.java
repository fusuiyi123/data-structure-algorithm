package com.dsalglc.dfs;

public class MaxAreaOfIsland {

    // 695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int tempArea = area(grid, i, j);
                    if (tempArea > res) {
                        res = tempArea;
                    }
                }
            }
        }
        return res;
    }

    public int area(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + area(grid, i + 1, j) +  area(grid, i - 1, j) + area(grid, i, j - 1) + area(grid, i, j + 1);
    }
}
