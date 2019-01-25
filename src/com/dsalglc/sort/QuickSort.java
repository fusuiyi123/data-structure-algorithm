package com.dsalglc.sort;

import com.dsalglc.others.ShuffleArray;

import static com.dsalglc.sort.Helper.*;

// https://algs4.cs.princeton.edu/23quicksort/Quick.java.html
public class QuickSort {
    private QuickSort() {}

    public static void sort(Comparable[] a) {
        ShuffleArray.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    // kth smallest number  215. Kth Largest Element in an Array
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        ShuffleArray.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int i = partition(a, lo, hi);
            if (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,2,1,5,2,3,5,6,12,3,4};
        select(arr, 8);
        show(arr);
        sort(arr);
        show(arr);
        isSorted(arr);
    }
}
