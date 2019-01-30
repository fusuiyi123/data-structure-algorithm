package com.dsalglc.Interval;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    // private class IntervalComparator implements Comparator<Interval> {
    //     @Override
    //     public int compare(Interval a, Interval b) {
    //         return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    //     }
    // }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        // Collections.sort(intervals, new Comparator<Interval>() {
        //     public int compare(Interval a, Interval b) {
        //         return a.start - b.start;
        //     }
        // });
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval: intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }
}
