package com.leetcode;

import com.leetcode.arraystring.ArrayStrings;
import com.leetcode.arraystring.HistogramOfArray;
import com.leetcode.arraystring.ReorderArrayBasedonIndexes;

public class Main {


    public static void main(String[] args) {



        // 3045982 = 99·313 + 97·312 + 108·311 + 108·310 = 108 + 31· (108 + 31 · (97 + 31 · (99)))
//        String s = "call";
//        int code = s.hashCode();
//        System.out.println(code);
//
//        ArrayStrings instance = new ArrayStrings();
//        int[] res = instance.maxSlidingWindow(new int[]{1,5,3,6,32,2,1,2}, 3);
//        for (int n : res) {
//            System.out.print(n + ",");
//        }
//        HistogramOfArray.printHistogram(new int[]{0,11,2,13,5,12,8,11,12,9});
        ReorderArrayBasedonIndexes.reorder(new int[]{50, 40, 70, 60, 90}, new int[]{3,  0,  4,  1,  2});
    }
}
