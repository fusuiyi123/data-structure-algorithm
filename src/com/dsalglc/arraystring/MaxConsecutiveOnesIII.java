package com.dsalglc.arraystring;

public class MaxConsecutiveOnesIII {

    // 1004. Max Consecutive Ones III
    public int longestOnes(int[] A, int K) {
        int res = 0, left = 0, right = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                K--;
            }
            while (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
