package com.dsalglc.dp;

public class JumpGame {
    // 55. Jump Game
    // greedy
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    // 45. Jump Game II
    // BFS
    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int level = 0, i = 0, currMax = 0;
        while (currMax - i >= 0) {
            level++;
            int next = 0;
            for (; i <= currMax; i++) {
                next = Math.max(next, nums[i] + i);
                if (next >= nums.length - 1) return level;
            }
            currMax = next;
        }
        return 0;
    }
}
