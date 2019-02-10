package com.dsalglc.arraystring;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    // 992. Subarrays with K Different Integers
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K-1);
    }

    private int atMostK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, res = 0;
        for (int j = 0; j < A.length; j++) {
            int x = map.getOrDefault(A[j], 0);
            if (x == 0) K--;
            map.put(A[j], x+1);
            while (K < 0) {
                int y = map.get(A[i]);
                map.put(A[i], y - 1);
                if (y - 1 == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
