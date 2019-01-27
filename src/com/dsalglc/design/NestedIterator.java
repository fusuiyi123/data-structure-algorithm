package com.dsalglc.design;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger e = stack.peek().next();
                if (e.isInteger()) {
                    stack.peek().previous();
                    return true;
                }
                stack.push(e.getList().listIterator());
            }
        }
        return false;
    }
}
