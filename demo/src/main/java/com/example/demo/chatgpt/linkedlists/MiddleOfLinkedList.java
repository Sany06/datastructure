package com.example.demo.chatgpt.linkedlists;
//https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow= head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
