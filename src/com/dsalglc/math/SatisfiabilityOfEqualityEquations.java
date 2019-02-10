package com.dsalglc.math;

import com.dsalglc.graph.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class SatisfiabilityOfEqualityEquations {
    // TODO: DFS
    // Input: ["a==b","b!=a"]
    // Output: false
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            String op = equation.substring(1,3);
            if (op.equals("==")) {
                uf.union(a - 'a', b - 'a');
            } else {
                index.add(i);
            }
        }
        for (int i : index) {
            String equation = equations[i];
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (uf.find(a - 'a') == uf.find(b - 'a')) {
                return false;
            }
        }
        return true;
    }
}
