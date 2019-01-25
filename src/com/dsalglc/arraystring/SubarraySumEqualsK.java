package com.dsalglc.arraystring;

import java.util.HashMap;

// 560. Subarray Sum Equals K
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int curr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (map.containsKey(curr - k)) {
                res += map.get(curr - k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }
}
