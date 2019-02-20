package com.dsalglc.math;

public class UglyNumber {
    // 263. Ugly Number
    // Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 & num > 0; i++) {
            while (num % i == 0)
                num /= i;
        }
        return num == 1;
    }

    // 264. Ugly Number II
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] f = new int[n];
        f[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < n; i++) {
            int x = Math.min(f[t2]*2, Math.min(f[t3]*3, f[t5]*5));
            if (x == f[t2]*2) t2++;
            if (x == f[t3]*3) t3++;
            if (x == f[t5]*5) t5++;
            f[i] = x;
        }
        return f[n-1];
    }
}
