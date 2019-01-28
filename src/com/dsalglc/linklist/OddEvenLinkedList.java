package com.dsalglc.linklist;

public class OddEvenLinkedList {

    // 328. Odd Even Linked List
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, evenHead = head.next, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
