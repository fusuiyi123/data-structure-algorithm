package com.leetcode.tree;

public class BinaryIndexTree {
    int[] btree;
    int[] arr;

    public BinaryIndexTree(int[] nums) {
        btree = new int[nums.length + 1];
        arr = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i , nums[i]);
        }
    }

    private void add(int i, int val) {
        for (int j = i + 1; j < btree.length; j = j + (j & -j)) {
            btree[j] += val;
        }
    }

    public void update(int i, int val) {
        add(i, val - arr[i]);
        arr[i] = val;
    }

    private int sumHelper(int i) {
        int sum = 0;
        for (int j = i + 1; j >= 1; j = j - (j & -j)) {
            sum += btree[j];
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return sumHelper(j) - sumHelper(i-1);
    }
}
