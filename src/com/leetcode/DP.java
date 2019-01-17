package com.leetcode;

import java.util.*;

public class DP {

    // 53 Maximum Subarray
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 198 House Robber
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    // 873. Length of Longest Fibonacci Subsequence
    public int lenLongestFibSubseq(int[] A) {
        // (b-a, a, b)
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            index.put(A[i], i);
            for (int j = 0; j < i; j++) {
                int k = index.getOrDefault(A[i] - A[j], -1);
                dp[j][i] = (A[i] - A[j] < A[j] && k != - 1) ? dp[k][j] + 1 : 2;
                res = Math.max(res, dp[j][i]);
            }
        }
        return res > 2 ? res : 0;
    }
    public int lenLongestFibSubseq1(int[] A) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i], b = A[j], l = 2;
                while (set.contains(a+b)) {
                    int tmp = a + b;
                    a = b;
                    b = tmp;
                    l++;
                }
                res = Math.max(res, l);
            }
        }
        return res > 2 ? res : 0;
    }

    // 55 Jump Game
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    // 322 Coin Change
    public int coinChange(int[] coins, int amount) {
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
    public int change(int amount, int[] coins) {
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

    // 300 Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tempMax = Math.max(tempMax, dp[j]);
                }
            }
            dp[i] = tempMax + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 312. Burst Balloons
    // Time Complexity O(n^3)??
    public int maxCoins(int[] nums) {
        int[] nums1 = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) nums1[n++] = x;
        }
        nums1[0] = nums1[n++] = 1;
        int[][] memo = new int[n][n];
        return burst(nums1, memo, 0, n-1);
    }

    private int burst(int[] nums, int[][] memo, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, nums[left] * nums[i] * nums[right] +  burst(nums, memo, left, i) + burst(nums, memo, i, right));
        }
        memo[left][right] = res;
        return res;
    }
}
