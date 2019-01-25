package com.dsalglc.others;

import java.util.Arrays;

public class TaskScheduler {

    // 621. Task Scheduler
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int maxCount = count[25] - 1, idleSlots = maxCount * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idleSlots -= Math.min(count[i], maxCount);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    public int leastInterva1l(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        int maxCount = 0, numMax = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                numMax = 1;
            } else if (count[i] == maxCount) {
                numMax++;
            }
        }
        return  Math.max((maxCount - 1) * (n + 1) + numMax, tasks.length);
    }
}
