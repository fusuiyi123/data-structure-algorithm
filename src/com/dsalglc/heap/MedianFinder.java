package com.dsalglc.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;
    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if (hi.size() > lo.size())
            lo.add(hi.poll());
    }

    public double findMedian() {
        if (lo.size() == hi.size())
            return (double)(lo.peek() + hi.peek()) / 2.0;
        else
            return lo.peek();
    }
}
