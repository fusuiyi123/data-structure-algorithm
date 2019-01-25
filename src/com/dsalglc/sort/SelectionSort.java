package com.dsalglc.sort;


import static com.dsalglc.sort.Helper.*;

public class SelectionSort {
    private SelectionSort() {}

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{4,3,5,6,8,3,2};
        sort(a);
        show(a);
    }
}
