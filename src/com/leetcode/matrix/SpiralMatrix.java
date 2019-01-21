package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // 54. Spiral Matrix
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length; int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[r][c]);
            visited[r][c] = true;
            int[] dir = dirs[di];
            int rc = r + dir[0];
            int cc = c + dir[1];
            if (rc >= 0 && rc < m && cc >= 0 && cc < n && !visited[rc][cc]) {
                r = rc;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dirs[di][0];
                c += dirs[di][1];
            }
        }
        return res;
    }
}
