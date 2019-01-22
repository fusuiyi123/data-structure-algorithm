package com.leetcode.linklist;

public class RemoveNthFromEnd {
    // 19. Remove Nth Node From End of List
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        while (fast != null) {
            fast = fast.next;
            n--;
            if (n == 0) {
                break;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}

