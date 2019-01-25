package com.dsalglc.others;

import java.util.Random;

public class ShuffleArray {
    private ShuffleArray() {}

    public static void shuffle(Comparable[] a) {
        int n = a.length;
        Random rand = new Random();
        for (int i = n - 1; i >= 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(a, index, i);
        }
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
