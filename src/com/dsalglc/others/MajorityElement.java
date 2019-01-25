package com.dsalglc.others;

public class MajorityElement {
    // 169. Majority Element Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer majority = null;
        for (int n : nums) {
            if (count == 0) {
                majority = n;
            }
            count += (n == majority) ? 1 : -1;
        }
        return majority;
    }
}
