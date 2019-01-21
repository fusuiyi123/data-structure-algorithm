package com.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    // 322. Coin Change
    // You are given coins of different denominations and a total amount of money amount.
    // Write a function to compute the fewest number of coins that you need to make up that amount.
    // If that amount of money cannot be made up by any combination of the coins, return -1.
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 518. Coin Change 2
    // Write a function to compute the number of combinations that make up that amount.
    // You may assume that you have infinite number of each kind of coin.
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - coins[i-1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
