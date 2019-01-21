package com.leetcode.dp;

import java.util.*;

public class WordBreak {

    // 139. Word Break
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 140. Word Break II
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> map = new HashMap<>();
        return dfs(s, dict, 0, map);
    }

    private static List<String> dfs(String s, Set<String> dict, int start, Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        ArrayList<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (dict.contains(word)) {
                List<String> temp = dfs(s, dict, i, map);
                for (String str : temp) {
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(start, res);
        return res;

    }
}
