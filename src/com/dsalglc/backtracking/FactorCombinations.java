package com.dsalglc.backtracking;

import java.util.ArrayList;
import java.util.List;

// 254. Factor Combinations
public class FactorCombinations {
    // time: TODO
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> curr, int n, int start) {
        int sqn = (int)Math.floor(Math.sqrt(n));
        if (n == 1) {
            if (curr.size() > 1)
                res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (i > sqn) {
                i = n;
            }
            if (n % i == 0) {
                curr.add(i);
                backtracking(res, curr, n / i, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
