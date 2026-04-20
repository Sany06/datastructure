package selfpracticeproblems.linkedlist.basicopertions;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step - 1
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //Step - 2
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next=slow.next.next;

        return dummy.next;
    }
}
