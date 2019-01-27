package com.dsalglc.dp;

public class PaintHouse {

    // 265. Paint House II
    public static int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int x1 = -1, x2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != min1) {
                    dp[i][j] = i >= 1 ? dp[i-1][min1] + costs[i][j] : costs[i][j];
                } else {
                    dp[i][j] = i >= 1 ? dp[i-1][min2] + costs[i][j] : costs[i][j];
                }
                if (x1 == -1 || dp[i][j] < dp[i][x1]) {
                    x2 = x1; x1 = j;
                } else if (x2 == -1 || dp[i][j] < dp[i][x2]) {
                    x2 = j;
                }
            }
            min1 = x1; min2 = x2;
        }
        return dp[n-1][min1];
    }
}
