package com.leetcode.arraystring;

import java.util.LinkedList;

public class SlidingWindowMaximum {

    class MonotonicQueue<Key extends Comparable<Key>> {
        LinkedList<Key> list;
        MonotonicQueue() {
            list = new LinkedList<>();
        }

        void push(Key val) {
            while (!list.isEmpty() && val.compareTo(list.peekLast()) > 0) {
                list.pollLast();
            }
            list.offer(val);
        }

        void pop() {
            list.pop();
        }

        Key getMax() {
            assert !list.isEmpty();
            return list.peekFirst();
        }
    }

    // 233. Sliding Window Maximum
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        MonotonicQueue<Integer> monotonicQueue = new MonotonicQueue<>();
        for (int i = 0; i < n; i++) {
            monotonicQueue.push(nums[i]);
            if (i - k + 1 >= 0) {
                res[ri++] = monotonicQueue.getMax();
                if (nums[i-k+1] == monotonicQueue.getMax()) {
                    monotonicQueue.pop();
                }
            }
        }

        return res;
    }

}
