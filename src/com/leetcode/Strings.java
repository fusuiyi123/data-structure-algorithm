package com.leetcode;

public class Strings {

    // 214. Shortest Palindrome
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
