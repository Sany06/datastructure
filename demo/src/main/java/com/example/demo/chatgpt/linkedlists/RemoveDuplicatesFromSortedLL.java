package com.example.demo.chatgpt.linkedlists;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicatesFromSortedLL {
    public ListNode deleteDuplicates(ListNode node) {
        if(node==null){
            return node;
        }
        ListNode head=node;
        while(node.next!=null){
            if(node.val==node.next.val){
                node.next=node.next.next;
            } else{
                node=node.next;
            }
        }
        return head;
    }
}
