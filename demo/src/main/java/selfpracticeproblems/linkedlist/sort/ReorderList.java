package selfpracticeproblems.linkedlist.sort;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Break the connection after min and Reverse second half
        ListNode curr = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Merge two halves
        ListNode fh = head;
        ListNode sh = prev;

        while (sh != null) {
            ListNode temp1 = fh.next;
            ListNode temp2 = sh.next;

            fh.next = sh;
            sh.next = temp1;

            fh = temp1;
            sh = temp2;
        }
    }
}
