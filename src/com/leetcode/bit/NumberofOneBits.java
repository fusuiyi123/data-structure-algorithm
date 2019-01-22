package com.leetcode.bit;

// 191. Number of 1 Bits
// Write a function that takes an unsigned integer and return the number of '1' bits it has
// (also known as the Hamming weight).
public class NumberofOneBits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
