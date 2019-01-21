package com.leetcode.dp;

public class UniquePaths {

    // 62. Unique Paths
    public static int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1;
        // }
        // for (int j = 0; j < n; j++) {
        //     dp[0][j] = 1;
        // }
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        // return dp[m - 1][n - 1];

        if (m > n) {
            return uniquePaths(n, m);
        }

        int[] prev = new int[m];
        int[] curr = new int[m];
        for (int i = 0; i < m; i++) {
            prev[i] = 1;
            curr[i] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) curr[i] = curr[i - 1] + prev[i];
            for (int i = 0; i < m; i++) prev[i] = curr[i];
        }
        return curr[m - 1];
    }

    // 63. Unique Paths II
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        // note the initialization!
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
