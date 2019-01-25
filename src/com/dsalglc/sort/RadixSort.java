package com.dsalglc.sort;

import java.util.Arrays;

// https://www.geeksforgeeks.org/radix-sort/
public class RadixSort {
    private RadixSort() {}

    // O((n+b)*log_b(k)))
    public static void sort(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

    private static void countSort(int[] a, int exp) {
        int n = a.length;
        int[] res = new int[n];
        int[] count = new int[10];
        Arrays.fill(count,0);
        for (int x : a) {
            count[(x/exp)%10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }
        for (int i = n - 1; i >= 0; i--) {
            res[--count[(a[i]/exp)%10]] = a[i];
        }
        for (int i = 0; i < n; i++) {
            a[i] = res[i];
        }
    }

    private static int getMax(int[] a) {
        int max = a[0];
        for (int x : a) {
            if (x > max) max = x;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        sort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }
}
