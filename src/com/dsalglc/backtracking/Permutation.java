package com.dsalglc.backtracking;

import java.util.*;

public class Permutation {

    // 46. Permutations
    // Time: O(n*n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) list.add(n);
        backtracking(res, list, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int start) {
        if (start >= list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            backtracking(res, list, start + 1);
            Collections.swap(list, start, i);
        }
    }



    // 47. Permutations II with duplicate
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        // Arrays.sort(nums);
        for (int n : nums) list.add(n);
        backtracking1(res, list, 0);
        boolean[] visited = new boolean[nums.length];
        return res;
    }

    private void backtracking1(List<List<Integer>> res, List<Integer> list, int start) {
        if (start == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = start; i < list.size(); i++) {
            if (set.contains(list.get(i))) continue; // do not swap
            set.add(list.get(i));
            Collections.swap(list, start, i);
            backtracking1(res, list, start + 1);
            Collections.swap(list, start, i);
        }
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
}
