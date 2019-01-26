package com.dsalglc.graph;

import java.util.*;

public class AlienDictionary {
    // 269. Alien Dictionary
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        for (String word: words) {
            for (char c: word.toCharArray()) {
                degree[c - 'a'] = 0;
            }
        }
        int dictSize = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] != -1) {
                dictSize++;
            }
        }

        // build directed graph
        for (int i = 0; i < words.length - 1; i++) {
            char[] curr = words[i].toCharArray();
            char[] next = words[i+1].toCharArray();
            int len = Math.min(curr.length, next.length);
            for (int j = 0; j < len; j++) {
                if (curr[j] != next[j]) {
                    if (!map.containsKey(curr[j])) {
                        map.put(curr[j], new HashSet<>());
                    }
                    HashSet<Character> set = map.get(curr[j]);
                    if (!set.contains(next[j])) {
                        set.add(next[j]);
                        degree[next[j] - 'a']++;
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                queue.offer((char)('a' + i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                HashSet<Character> set = map.get(c);
                for (char c1: set) {
                    degree[c1 - 'a']--;
                    if (degree[c1 - 'a'] == 0) {
                        queue.offer(c1);
                    }
                }
            }
        }
        String res = sb.toString();
        return res.length() == dictSize ? res : "";
    }
}
