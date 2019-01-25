package com.dsalglc.sort;

import java.util.*;

public class BucketSort {
    private BucketSort() {}
    // https://www.javacodex.com/Sorting/Bucket-Sort
    public static void sort(int[] a, int maxVal) {
        int[] bucket = new int[maxVal + 1];
        Arrays.fill(bucket, 0);

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
            }
        }

    }

    // 347. Top K Frequent Elements
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n: nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (int key: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int maxVal=5;
        int [] data= {5,3,0,2,4,1,0,5,2,3,1,4};

        System.out.println("Before: " + Arrays.toString(data));
        sort(data,maxVal);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
