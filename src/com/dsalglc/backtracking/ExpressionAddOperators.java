package com.dsalglc.backtracking;

import java.util.ArrayList;
import java.util.List;

// 282. Expression Add Operators
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<>();
        backtracking(res, num, "", 0, 0, 0, target);
        return res;
    }

    // Time: O(N*4^N) TODO ?
    private void backtracking(List<String> res, String num, String curr, int start, long eval, long prev, int target) {
        if (start == num.length()) {
            if (eval == target)
                res.add(curr);
            return;
        }

        for (int i = start; i < num.length(); i++) {
            if (i > start && num.charAt(start) == '0') break;
            long n = Long.parseLong(num.substring(start, i+1));
            if (start == 0) {
                backtracking(res, num, curr + n, i + 1, n, n, target);
            } else {
                backtracking(res, num, curr + "+" + n, i + 1, eval + n, n, target);
                backtracking(res, num, curr + "-" + n, i + 1, eval - n, -n, target);
                backtracking(res, num, curr + "*" + n, i + 1, eval - prev + prev * n, prev * n, target);
            }
        }

    }
}
