package com.dsalglc.design;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {

    int res = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return res;
    }
    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger x : nestedList) {
            if (x.isInteger()) {
                res += x.getInteger() * depth;
            } else {
                dfs(x.getList(), depth + 1);
            }
        }
    }

    // 364. Nested List Weight Sum II
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int prev = 0, res = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger x : nestedList) {
            queue.offer(x);
        }
        while (!queue.isEmpty()) {
            int levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger x = queue.poll();
                if (x.isInteger()) levelSum += x.getInteger();
                else {
                    for (NestedInteger y : x.getList()) {
                        queue.offer(y);
                    }
                }
            }
            prev += levelSum;
            res += prev;
        }
        return res;
    }
}
