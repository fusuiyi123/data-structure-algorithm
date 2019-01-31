package com.dsalglc.Interval;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        // Collections.sort(intervals, new Comparator<Interval>() {
        //     @Override
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
