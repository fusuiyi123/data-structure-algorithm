package com.dsalglc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // 131. Palindrome Partitioning
    // Given a string s, partition s such that every substring of the partition is a palindrome.
    // input: "aab"
    // output:
    // [
    //  ["aa","b"],
    //  ["a","a","b"]
    // ]

    // time: O(n*2^n) space: (O(n*2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), 0, s);
        return res;
    }

    private void backtracking(List<List<String>> res, List<String> temp, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String tmp = s.substring(start, i);
            if (isPalindrome(tmp)) {
                temp.add(tmp);
                backtracking(res, temp, i, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
