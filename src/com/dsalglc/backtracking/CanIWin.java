package com.dsalglc.backtracking;

import java.util.HashMap;

// 464. Can I Win
public class CanIWin {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger+1];
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        return backtracking(map, desiredTotal, used);
    }

    // Time: O(2^n)
    private boolean backtracking(HashMap<Integer, Boolean> map, int desiredTotal, boolean[] used) {
        if (desiredTotal <= 0) return false;
        int key = transform(used);
        if (map.containsKey(key)) return map.get(key);
        for (int i = 1; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            boolean oppWin = backtracking(map, desiredTotal - i, used);
            if (!oppWin) {
                map.put(key, true);
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        map.put(key, false);
        return false;
    }

    private int transform(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) num |= 1;
        }
        return num;
    }
}
