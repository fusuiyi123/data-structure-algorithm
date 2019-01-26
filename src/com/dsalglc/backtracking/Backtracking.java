package com.dsalglc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

    // 47. Permutations II
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(res, new ArrayList<>(), visited, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtracking(res, temp, visited, nums);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    // 90. Subsets II
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            backtracking(res, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    // 40. Combination Sum II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            backtracking(res, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }

    }

    // 131. Palindrome Partitioning
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), 0, s);
        return res;
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void backtracking(List<List<String>> res, List<String> temp, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String tmp = s.substring(start, i);
            if (isPalindrome(tmp)) {
                temp.add(tmp);
                backtracking(res, temp, i, s);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
