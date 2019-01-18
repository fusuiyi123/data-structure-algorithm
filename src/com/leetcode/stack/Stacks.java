package com.leetcode.stack;

import java.util.Stack;

public class Stacks {


    // 227. Basic Calculator II
    // Input: "3+2*2"
    // Output: 7
    public int calculate2(String s) {
        int len = s.length();
        if (len == 0) return 0;
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        for (int n : stack) {
            res += n;
        }
        return res;
    }

    // 224. Basic Calculator
    // Input: "(1+(4+5+2)-3)+(6+8)"
    // Output: 23
    public int calculate(String s) {
        int sign = 1, res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    sum = sum * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                res += sign * sum;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }

    // 772. Basic Calculator III
    // "2*(5+5*2)/3+(6/2+8)" = 21
    public int calculate3(String s) {
        Stack<Integer> vals = new Stack<>();
        Stack<Character> ops = new Stack<>();


        return 0;
    }
}
