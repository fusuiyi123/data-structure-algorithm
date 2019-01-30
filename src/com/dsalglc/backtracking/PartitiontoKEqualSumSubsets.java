package com.dsalglc.backtracking;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {
    // 698. Partition to K Equal Sum Subsets

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length - 1, visited, sum / k, k);
    }

    // time: O(n*2^n), space: O(n) ? TODO
    private boolean dfs(int[] nums, int sum, int end, boolean[] visited, int target, int k) {
        if (k == 0) return true;
        if (sum == target) {
            return dfs(nums, 0, nums.length - 1, visited, target, k - 1); // end is nums.length - 1!
        }
        for (int i = end; i >= 0; i--) {
            if (visited[i]) continue;
            if (sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, sum + nums[i], i - 1, visited, target, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
