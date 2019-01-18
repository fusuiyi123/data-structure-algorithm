package com.leetcode.arraystring;

// 53. Maximum Subarray
public class MaximumSubarray {
    // Kadane's Algorithm
    public static int maxSubArray(int[] nums) {

        int res = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = currMax < 0 ? nums[i] : currMax + nums[i];
            res = Math.max(res, currMax);
        }
        return res;
    }
}
