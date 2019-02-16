package com.dsalglc.others;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    // 169. Majority Element Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = nums[0];
        for (int n : nums) {
            if (num == n) {
                count++;
            } else if (count == 0) {
                num = n;
                count = 1;
            } else {
                count--;
            }
        }
        return num;
    }

    // 229. Majority Element II
    // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    public List<Integer> majorityElement1(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
        for (int n : nums) {
            if (num1 == n) {
                count1++;
            } else if (num2 == n) {
                count2++;
            } else if (count1 == 0) {
                num1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        int len = nums.length;
        count1 = 0; count2 = 0;
        for (int n : nums) {
            if (num1 == n) count1++;
            else if (num2 == n) count2++; // avoid duplicate
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > len / 3) res.add(num1);
        if (count2 > len / 3) res.add(num2);
        return res;
    }
}
