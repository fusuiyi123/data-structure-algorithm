package com.dsalglc.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    // 49. Group Anagrams
    // sort each word. time: O(n*k*log(k)), space: O(n*k)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sortedS = new String(temp);
            if (!res.containsKey(sortedS)) res.put(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    // word count. time: O(n*k), space: O(n*26)
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> res = new HashMap<>();
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
            if (!res.containsKey(key)) res.put(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
