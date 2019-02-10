package com.dsalglc.arraystring;

public class LongestSubstringWithAtMostKDistinctCharacters {

    // 340. Longest Substring with At Most K Distinct Characters
    // sliding window
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            while (num > k) {
                if (--count[s.charAt(i++)] == 0) {
                    num--;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
