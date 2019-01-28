package com.dsalglc.linklist;

public class SwapNodesinPairs {

    // 24. Swap Nodes in Pairs
    // input: 1->2->3->4 output: 2->1->4->3
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            second.next = first;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
