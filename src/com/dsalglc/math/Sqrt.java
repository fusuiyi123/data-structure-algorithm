package com.dsalglc.math;

public class Sqrt {
    // 69. Sqrt(x)
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
