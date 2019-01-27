package com.dsalglc.stack;

import java.util.Stack;

// 716. Max Stack
// Design a max stack that supports push, pop, top, peekMax and popMax.
public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        if (maxStack.isEmpty() || x > peekMax()) {
            maxStack.push(x);
        } else {
            maxStack.push(peekMax());
        }
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> temp = new Stack<>();
        int max = peekMax();
        while (top() != max) {
            temp.push(pop());
        }
        pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }
}
