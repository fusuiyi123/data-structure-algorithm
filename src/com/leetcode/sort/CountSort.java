package com.leetcode.sort;

import java.util.Arrays;

// https://www.geeksforgeeks.org/counting-sort/
public class CountSort {
    private CountSort() {}

    // Time: O(n+k), Space: O(n+k)
    public static void sort(int[] a) {
        if (a.length == 0) return;
        int n = a.length;
        int min = getMin(a), max = getMax(a);
        int range = max - min + 1;
        int[] count = new int[range];
        Arrays.fill(count,0);
        int[] res = new int[n];
        for (int x : a) {
            count[x-min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i = n - 1; i >= 0; i--) {
            res[--count[a[i]-min]] = a[i];
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

    private static int getMin(int[] a) {
        int min = a[0];
        for (int x : a) {
            if (x < min) min = x;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-3,-6,3,6,8,3,6,7};
        sort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }
}
