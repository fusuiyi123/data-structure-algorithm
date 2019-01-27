package com.dsalglc.stack;

import java.util.Stack;

// 155. Min Stack
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= getMin()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (top() == getMin()) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
