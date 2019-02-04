package com.dsalglc.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    // 301. Remove Invalid Parentheses
    // Time: O(2^n), Space: O(n)
    private Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL > 0)
                    rmL--;
                else
                    rmR++;
            }
        }
        dfs(s, 0, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(set);
    }

    private void dfs(String s, int i, StringBuilder sb, int rmL, int rmR, int open) {
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0)
                set.add(sb.toString());
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();
        if (c == '(') {
            if (rmL > 0) dfs(s, i + 1, sb, rmL - 1, rmR, open);
            dfs(s, i + 1, sb.append(c), rmL, rmR, open + 1);
        } else if (c == ')') {
            if (rmR > 0) dfs(s, i + 1, sb, rmL, rmR - 1, open);
            if (open > 0) dfs(s, i + 1, sb.append(c), rmL, rmR, open - 1);
        } else {
            dfs(s, i + 1, sb.append(c), rmL, rmR, open);
        }
        sb.setLength(len);
    }
}
