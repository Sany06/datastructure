package com.example.demo.chatgpt.linkedlists;

public class PalindromeLinkList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow= head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast!=null){
            slow=slow.next;
        }
        slow=reverseList(slow);
        fast=head;
        
        while (slow!=null){
            if (fast.val!= slow.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode current=head;
    while (current!=null){
        ListNode next=current.next;
        current.next=prev;
        prev=current;
        current=next;
    }
    return prev;
    }
}
