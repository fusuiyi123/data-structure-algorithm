package com.dsalglc.linklist;

import static com.dsalglc.linklist.ReverseList.reverseList;

public class ReorderList {
    // 143. Reorder List
    // input: L_0->L_1->...->L_n-1->L_n
    // output: L_0->L_n->L_1->L_n-1->L_2->L_n-2->....
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p1 = head;
        ListNode p2 = reverseList(slow.next);
        slow.next = null;
        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }
}
