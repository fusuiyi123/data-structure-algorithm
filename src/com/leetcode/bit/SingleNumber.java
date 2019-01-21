package com.leetcode.bit;

public class SingleNumber {
    // 136. Single Number
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }


}
