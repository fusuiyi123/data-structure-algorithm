package com.dsalglc.bit;

public class CountingBits {
    // 338. Counting Bits
    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
