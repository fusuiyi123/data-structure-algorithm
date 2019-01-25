package com.dsalglc.arraystring;


// 238. Product of Array Except Self
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for (int j = n - 1; j >= 1; j--) {
            right *= nums[j];
            res[j-1] = res[j-1] * right;
        }
        return res;
    }
}
