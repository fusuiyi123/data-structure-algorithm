package com.dsalglc.bit;

public class ReverseBits {

    // 190. Reverse Bits
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n >>>= 1;
            result = (result << 1) | end;
        }
        return result;
    }
}
