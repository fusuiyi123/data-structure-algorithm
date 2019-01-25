package com.dsalglc.sort;
import static com.dsalglc.sort.Helper.*;

// https://algs4.cs.princeton.edu/21elementary/Insertion.java.html
public class InsertionSort {
    private InsertionSort() {}

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                swap(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{4,5,6,3,2,1};
        sort(a);
    }
}
