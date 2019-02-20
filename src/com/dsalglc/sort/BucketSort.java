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


    // 274. H-Index
    // "A scientist has index h if h of his/her N papers have at least h citations each,
    // and the other N − h papers have no more than h citations each."
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n+1];
        for (int c : citations) {
            if (c >= n) bucket[n]++;
            else bucket[c]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) return i;
        }
        return 0;
    }

    // 275. H-Index II TODO binary search
    // Given an array of citations sorted in ascending order (each citation is a non-negative integer)
    // of a researcher, write a function to compute the researcher's h-index.
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] >= n - mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return n - lo;
    }

    public static void main(String[] args) {
        int maxVal=5;
        int [] data= {5,3,0,2,4,1,0,5,2,3,1,4};

        System.out.println("Before: " + Arrays.toString(data));
        sort(data,maxVal);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
