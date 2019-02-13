package com.dsalglc.bit;

public class BitwiseANDofNumbersRange {
    // Given a range [m, n] where 0 <= m <= n <= 2147483647,
    // return the bitwise AND of all numbers in this range, inclusive.
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
