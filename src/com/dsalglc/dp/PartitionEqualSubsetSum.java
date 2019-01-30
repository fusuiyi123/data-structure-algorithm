package com.dsalglc.dp;

public class PartitionEqualSubsetSum {
    // 416. Partition Equal Subset Sum
    // Given a non-empty array containing only positive integers,
    // find if the array can be partitioned into two subsets such that
    // the sum of elements in both subsets is equal.
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }


        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
