package com.dsalglc.sort;

public class Helper {
    /***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    public static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }


    public static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void show(Comparable[] a) {
        for (Comparable x : a) {
            System.out.print(x + ",");
        }
    }

}
