package com.dsalglc.arraystring;

public class ShortestPalindrome {
    // 214. Shortest Palindrome
    // time: O(n^2), space: O(n)
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, n - i).equals(rev.substring(i)))
                return rev.substring(0, i) + s;
        }
        return "";
    }
}
