package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Array {

    // 238 Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for (int j = n - 1; j >= 1; j--) {
            right *= nums[j];
            res[j-1] = res[j-1] * right;
        }
        return res;
    }

    //  54 Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length; int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[r][c]);
            visited[r][c] = true;
            int[] dir = dirs[di];
            int rc = r + dir[0];
            int cc = c + dir[1];
            if (rc >= 0 && rc < m && cc >= 0 && cc < n && !visited[rc][cc]) {
                r = rc;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dirs[di][0];
                c += dirs[di][1];
            }
        }
        return res;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length; int n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res.add(matrix[rowStart][j]);
            }
            rowStart++;
            if (rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colStart > colEnd) break;

            for (int j = colEnd; j >= colStart; j--) {
                res.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if (rowStart > rowEnd) break;

            for (int i = rowEnd; i >= rowStart; i--) {
                res.add(matrix[i][colStart]);
            }
            colStart++;
            if (colStart > colEnd) break;
        }
        return res;
    }


    class MonotonicQueue {
        LinkedList<Integer> list;
        MonotonicQueue() {
            list = new LinkedList<>();
        }

        void push(int val) {
            while (!list.isEmpty() && val > list.peekLast()) {
                list.pollLast();
            }
            list.offer(val);
        }

        void pop() {
            list.pop();
        }

        int getMax() {
            assert !list.isEmpty();
            return list.peekFirst();
        }
    }

    // 233 Sliding Window Maximum
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        for (int i = 0; i < n; i++) {
            monotonicQueue.push(nums[i]);
            if (i - k + 1 >= 0) {
                res[ri++] = monotonicQueue.getMax();
                if (nums[i-k+1] == monotonicQueue.getMax()) {
                    monotonicQueue.pop();
                }
            }
        }

        return res;
    }


    // 83 Remove Duplicates from Sorted List
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    // 189. Rotate Array
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate1(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    // 136 Single Number
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }

    // 36 valid sudoku
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sub = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                    if (row[i][num] != 0 || col[j][num] != 0 || sub[k][num] != 0) {
                        return false;
                    } else {
                        row[i][num] = 1;
                        col[j][num] = 1;
                        sub[k][num] = 1;
                    }
                }
            }
        }
        return true;
    }


}
