package com.leetcode.heap;

import java.util.*;

// 347. Top K Frequent Elements
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (Map.Entry element : map.entrySet()) {
            pq.add((Integer)element.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }

}
