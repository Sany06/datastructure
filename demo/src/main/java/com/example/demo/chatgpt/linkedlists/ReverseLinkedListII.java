package com.example.demo.chatgpt.linkedlists;

public class ReverseLinkedListII {

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
