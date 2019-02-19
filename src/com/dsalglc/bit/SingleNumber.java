package com.dsalglc.bit;

public class SingleNumber {

    // 136. Single Number
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }

    // TODO 137. Single Number II
    // Given a non-empty array of integers, every element appears three times except for one,
    // which appears exactly once. Find that single one.
    public int singleNumber2(int[] nums) {
        return 0;
    }


    // 260. Single Number III
    // Given an array of numbers nums, in which exactly two elements appear only once
    // and all the other elements appear exactly twice. Find the two elements that appear only once.
    public int[] singleNumber3(int[] nums) {

        // get xor of all num
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        // get last set bit
        diff &= -diff;
        int[] res = {0, 0};

        // divide into two group
        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
