package selfpracticeproblems.linkedlist.reverse;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        //Step-1 Traverse to the last node and connect it with head
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;

        //Step-2 traverse to the newlast by traversing (length - k) step
        k = k % length;
        ListNode newLast = head;
        for (int i = 1; i < length - k; i++) {
            newLast = newLast.next;
        }

        // Step 3 - New head will be next node of the new Last
        head = newLast.next;
        // Step 4 - Break the connection between newLast and head
        newLast.next = null;

        return head;
    }
}
