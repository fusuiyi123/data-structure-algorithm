package com.leetcode.dp;

public class BurstBalloons {
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
