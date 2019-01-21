package com.leetcode.arraystring;

import java.util.Arrays;

public class SubarraySumDivisiblebyK {
    // 974. Subarray Sums Divisible by K
    public static int subarraysDivByK(int[] A, int K) {
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
