package com.dsalglc.dp;

// 32. Longest Valid Parentheses
public class LongestValidParentheses {

    // s[i] == '(' dp[i] = 0
    // s[i] == ')'
    // - s[i-1] == '(' dp[i] = dp[i-2] + 2
    // - s[i-dp[i-1]-1] == '(' dp[i] = dp[i-1] + 2 +dp[i-dp[i-1]-1]
    public static int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int res = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(')
                    dp[i] = i - 2 >= 0 ? dp[i-2] + 2 : 2;
                else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(')
                    dp[i] = i - dp[i-1] - 2 >= 0 ? dp[i-1] + 2 + dp[i-dp[i-1]-2] : dp[i-1] + 2;
                res = Math.max(res, dp[i]);
            }
            // if (s.charAt(i) == '(') dp[i] = 0;
        }
        return res;
    }
}
