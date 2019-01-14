package com.leetcode;

import java.util.*;

public class ArrayStrings {

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

    // 15 3sum
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i-1]) {
                int start = i + 1, end = nums.length - 1;
                int target = -nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] < target) {
                        start++;
                    } else if (nums[start] + nums[end] > target) {
                        end--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start+1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end-1]) {
                            end--;
                        }
                        start++;
                        end--;
                    }
                }
            }
        }
        return res;
    }

    // 73 Set Matrix Zeroes
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 49 Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sortedS = new String(temp);
            if (!res.containsKey(sortedS)) {
                res.put(sortedS, new ArrayList<>());
            }
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    // 214. Shortest Palindrome
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, n - i).equals(rev.substring(i)))
                return rev.substring(0, i) + s;
        }
        return "";
    }

    // 38 Count and Say
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i+1)) {
                i++;
                count++;
            }
            res.append(count).append(prev.charAt(i));
        }
        return res.toString();
    }

    // 14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 3 Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            res = Math.max(res, end - start + 1);
            map.put(c, end);
            end++;
        }
        return res;
    }

    // 516 Longest Palindromic Substring
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j+1][i-1]);
                if (dp[j][i] && i - j + 1 > res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome1(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    // 974. Subarray Sums Divisible by K
    public int subarraysDivByK(int[] A, int K) {
        int mod[] = new int[K];
        Arrays.fill(mod, 0);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            mod[(sum % K + K) % K]++;
        }
        int res = 0;
        for (int i = 0; i < K; i++) {
            if (mod[i] > 1) {
                res += (mod[i] * (mod[i] - 1)) / 2;
            }
        }
        res += mod[0];
        return res;
    }
}
