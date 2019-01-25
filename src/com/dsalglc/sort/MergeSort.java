package com.dsalglc.sort;

import java.util.Arrays;

import static com.dsalglc.sort.Helper.*;

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
     *  Index merge sort.
     ***************************************************************************/
    private static void merge(Comparable[] a, int[] index, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = index[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                    index[k] = aux[j++];
            else if (j > hi)                     index[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
            else                                 index[k] = aux[i++];
        }
    }

    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        int[] aux = new int[n];
        sort(a, index, aux, 0, n - 1);
        return index;
    }

    private static void sort(Comparable[] a, int[] index, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid+1, hi);
        merge(a, index, aux, lo, mid, hi);
    }



    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,2,1,5,2,3,5,6,12,3,4};
        int[] res = indexSort(arr);
        System.out.println(Arrays.toString(res));
        sort(arr);
        show(arr);
        isSorted(arr);
    }

}
