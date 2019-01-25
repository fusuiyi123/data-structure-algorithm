package com.dsalglc.arraystring;


public class HistogramOfArray {

    public static void printHistogram(int[] a) {
        int max = 0;
        for (int x : a) {
            max = Math.max(max, x);
        }

        for (int i = max; i > 0; i--) {
            System.out.print(String.format("%3d", i));
            for (int j = 0; j < a.length; j++) {
                if (a[j] >= i) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 0; i < a.length + 1; i++) {
            System.out.print("--");
        }
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + " ");
        }

    }
}
