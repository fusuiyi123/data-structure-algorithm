package com.dsalglc.heap;

import java.util.PriorityQueue;

public class MergekSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Time: O(N*logk),
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        // PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
        //     @Override
        //     public int compare(ListNode node1, ListNode node2) {
        //         return node1.val - node2.val;
        //     }
        // });
        for (ListNode list: lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            node.next = new ListNode(temp.val);
            node = node.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }
        return dummyHead.next;
    }
}
