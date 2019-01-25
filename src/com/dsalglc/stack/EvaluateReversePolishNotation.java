package com.dsalglc.stack;

import java.util.Stack;

// 150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                S.add(S.pop()+S.pop());
            } else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else if (s.equals("*")) {
                S.add(S.pop() * S.pop());
            } else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }
}
