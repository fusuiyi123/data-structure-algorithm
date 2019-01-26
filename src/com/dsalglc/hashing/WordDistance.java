package com.dsalglc.hashing;

import java.util.ArrayList;
import java.util.HashMap;

// 244. Shortest Word Distance II
public class WordDistance {

    private HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            if (list1.get(i) < list2.get(j)) {
                res = Math.min(res, list2.get(j) - list1.get(i));
                i++;
            } else {
                res = Math.min(res, list1.get(i) - list2.get(j));
                j++;
            }
        }
        return res;
    }
}
