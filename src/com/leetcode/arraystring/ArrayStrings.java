package com.leetcode.arraystring;

import java.util.*;

public class ArrayStrings {

    // 49 Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sortedS = new String(temp);
            if (!res.containsKey(sortedS)) {
                res.put(sortedS, new ArrayList<>());
            }
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

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

    // 38 Count and Say
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i+1)) {
                i++;
                count++;
            }
            res.append(count).append(prev.charAt(i));
        }
        return res.toString();
    }

    // 14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 3 Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            res = Math.max(res, end - start + 1);
            map.put(c, end);
            end++;
        }
        return res;
    }



}
