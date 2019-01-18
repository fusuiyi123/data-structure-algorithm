package com.leetcode.arraystring;

import java.util.Arrays;

public class ReorderArrayBasedonIndexes {
    public static void reorder(int[] arr, int[] index) {
        for (int i = 0; i < arr.length; i++) {
            while (index[i] != i) {
                int temp1 = arr[index[i]];
                int temp2 = index[index[i]];
                arr[index[i]]= arr[i];
                index[index[i]] = index[i];
                arr[i] = temp1;
                index[i] = temp2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
