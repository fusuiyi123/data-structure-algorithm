package com.dsalglc.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 241. Different Ways to Add Parentheses
public class DifferentWaysToAddParentheses {
    private Map<String, List<Integer>> map = new HashMap<>();

    // Time: Catalan number https://en.wikipedia.org/wiki/Catalan_number
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> val1 = diffWaysToCompute(part1);
                List<Integer> val2 = diffWaysToCompute(part2);
                for (int v1 : val1) {
                    for (int v2 : val2) {
                        switch (c) {
                            case '+':
                                res.add(v1+v2);
                                break;
                            case '-':
                                res.add(v1-v2);
                                break;
                            case '*':
                                res.add(v1*v2);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
}
