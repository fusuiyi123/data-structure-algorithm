package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DP {
    // 873. Length of Longest Fibonacci Subsequence
    public int lenLongestFibSubseq(int[] A) {
        // (b-a, a, b)
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            index.put(A[i], i);
            for (int j = 0; j < i; j++) {
                int k = index.getOrDefault(A[i] - A[j], -1);
                dp[j][i] = (A[i] - A[j] < A[j] && k != - 1) ? dp[k][j] + 1 : 2;
                res = Math.max(res, dp[j][i]);
            }
        }
        return res > 2 ? res : 0;
    }
    public int lenLongestFibSubseq1(int[] A) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i], b = A[j], l = 2;
                while (set.contains(a+b)) {
                    int tmp = a + b;
                    a = b;
                    b = tmp;
                    l++;
                }
                res = Math.max(res, l);
            }
        }
        return res > 2 ? res : 0;
    }


}
