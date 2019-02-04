package com.dsalglc.Interval;

import java.util.ArrayList;

public class IntervalListIntersections {

    // 986. Interval List Intersections
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        ArrayList<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i].start, B[j].start);
            int end = Math.min(A[i].end, B[j].end);
            if (start <= end) {
                list.add(new Interval(start, end));
            }
            if (A[i].end < B[j].end) {
                i++;
            } else {
                j++;
            }
        }
        Interval[] res = new Interval[list.size()];
        for (int k = 0; k < list.size(); k++)
            res[k] = list.get(k);
        return res;
    }
}
