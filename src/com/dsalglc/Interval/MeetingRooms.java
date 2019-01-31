package com.dsalglc.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    // 252. Meeting Rooms
    // Given an array of meeting time intervals consisting of start and end times
    // [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start)
                return false;
        }
        return true;
    }

    // 253. Meeting Rooms II
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        pq.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i].end);
        }
        return pq.size();
    }

}
