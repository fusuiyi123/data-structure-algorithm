package com.dsalglc.arraystring;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    // 3. Longest Substring Without Repeating Characters
    // sliding window
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
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
