package com.leetcode.sort;

public class MergeSort {
    private MergeSort() {}


    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)          a[k] = aux[j++];
            else if (j > hi)           a[k] = aux[i++];
            else if (less(a[j], a[i])) a[k] = aux[j++];
            else                       a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);

    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    // merge sort
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    /***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (Comparable x : a) {
            System.out.print(x + ",");
        }
    }


    //

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,2,1,5,2,3,5,6,12,3,4};
        sort(arr);
        show(arr);
        isSorted(arr);
    }

}
