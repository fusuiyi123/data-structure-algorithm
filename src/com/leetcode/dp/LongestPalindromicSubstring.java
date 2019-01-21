package com.leetcode.dp;

public class LongestPalindromicSubstring {

    // 5. Longest Palindromic Substring
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j+1][i-1]);
                if (dp[j][i] && i - j + 1 > res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public static String longestPalindrome1(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
