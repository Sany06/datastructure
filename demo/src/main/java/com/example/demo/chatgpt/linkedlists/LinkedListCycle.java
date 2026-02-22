package com.example.demo.chatgpt.linkedlists;
//https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycle {
    public boolean hasCycle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(ListNode node) {
        int length=0;
        ListNode fast = node;
        ListNode slow = node;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=slow.next;
                length++;
                while(slow!=fast){
                    length++;
                }
            }
        }
        return length;
    }
}
