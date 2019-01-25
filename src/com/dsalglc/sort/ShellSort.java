package com.dsalglc.sort;
import static com.dsalglc.sort.Helper.*;

// https://algs4.cs.princeton.edu/21elementary/Shell.java.html
public class ShellSort {

    private ShellSort() {}

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        while (h < n / 3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    swap(a, j, j-h);
                }
            }
            h /= 3;
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{4,5,6,3,2,1};
        sort(a);
    }
}
