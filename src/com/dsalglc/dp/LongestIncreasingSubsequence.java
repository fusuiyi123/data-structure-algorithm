package com.dsalglc.dp;

public class LongestIncreasingSubsequence {

    // 300. Longest Increasing Subsequence
    public static int lengthOfLIS(int[] nums) {
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

}
