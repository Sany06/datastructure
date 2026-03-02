package com.example.demo.chatgpt.linkedlists;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
    if(lists==null || lists.length==0) {return null;}
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

    for(ListNode listNode:lists){
        if(listNode!=null){
            pq.offer(listNode);
        }
    }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next=node;
            tail=tail.next;

            if (node.next!=null){
                pq.offer(node.next);
            }
        }

        return dummy.next;

    }
}
