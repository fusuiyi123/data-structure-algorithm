package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Others {

    // 150. Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                S.add(S.pop()+S.pop());
            } else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else if (s.equals("*")) {
                S.add(S.pop() * S.pop());
            } else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    // 169 Majority Element Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer majority = null;
        for (int n : nums) {
            if (count == 0) {
                majority = n;
            }
            count += (n == majority) ? 1 : -1;
        }
        return majority;
    }

    // 621 Task Scheduler
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
        // System.out.println(numMax + "," + maxCount + "," + tasksType);
        // System.out.println(tasks.length);
        return  Math.max((maxCount - 1) * (n + 1) + numMax, tasks.length);

    }
}
