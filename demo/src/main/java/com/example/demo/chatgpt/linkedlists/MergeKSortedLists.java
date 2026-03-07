package com.example.demo.chatgpt.linkedlists;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //A dummy node is created so that we can poll a node from the pq and then add it next to the
        // dummy node so that a link list structure is formed
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        //adds the heads of the lists to the pq
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.offer(listNode);
            }
        }


        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;

    }
}
