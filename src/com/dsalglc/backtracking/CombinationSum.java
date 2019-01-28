package com.dsalglc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        // Arrays.sort(candidates);
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtracking(res, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }


    // 40. Combination Sum II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking1(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking1(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            backtracking1(res, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    // 216. Combination Sum III Find all possible combinations of k numbers that
    // add up to a number n, given that only numbers from 1 to 9 can be used and
    // each combination should be a unique set of numbers.
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), k, 1, n);
        return res;
    }


    private void backtracking(List<List<Integer>> res, List<Integer> temp, int k, int start, int n) {
        if (n < 0 || temp.size() > k) {
            return;
        }
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtracking(res, temp, k, i+1, n-i);
            temp.remove(temp.size() - 1);
        }
    }

    // 377. Combination Sum IV
    // nums = [1, 2, 3]
    // target = 4
    // (1, 1, 1, 1)
    // (1, 1, 2)
    // (1, 2, 1)
    // (1, 3)
    // (2, 1, 1)
    // (2, 2)
    // (3, 1)
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        Arrays.fill(res, -1);
        res[0] = 1;
        return backtracking(res, nums, target);
    }

    public int combDP(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public int backtracking(int[] res, int[] nums, int target) {
        if (res[target] != -1) {
            return res[target];
        }
        int combs = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                combs += backtracking(res, nums, target - nums[i]);
            }
        }
        res[target] = combs;
        return combs;
    }
}
