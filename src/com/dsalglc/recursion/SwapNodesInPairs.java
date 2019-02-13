package com.dsalglc.recursion;

import com.dsalglc.linklist.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = swapPairs(p2.next);
        p2.next = p1;
        p1.next = p3;
        return p2;
    }
}
