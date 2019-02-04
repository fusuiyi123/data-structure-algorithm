package com.dsalglc.Interval;

import java.util.Arrays;

public class NonoverlappingIntervals {

    // 435. Non-overlapping Intervals
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int count = 1, end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
}
