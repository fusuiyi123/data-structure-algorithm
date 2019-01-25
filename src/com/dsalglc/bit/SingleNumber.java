package com.dsalglc.bit;

// 136. Single Number
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }


}
