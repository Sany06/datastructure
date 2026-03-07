package com.example.demo.chatgpt.linkedlists;

public class ReverseLinkedListII {
//In this problem we need a leftprev pointer which will stop at one place back of the left(i.e the starting point of reversal)
    // and for this we have to create a dummy node and the leftprev will be starting from that dummy where dummy.next=head
    //We need two extra pointers that is leftprev and reference
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftprev = dummy;
        ListNode current = head;

        for (int i = 0; i < left - 1; i++) {
            leftprev = leftprev.next;
            current = current.next;
        }

        ListNode reference = current;
        ListNode prev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        leftprev.next = prev;
        reference.next = current;

        return dummy.next;
    }
}
