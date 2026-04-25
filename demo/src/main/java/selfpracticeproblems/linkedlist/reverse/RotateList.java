package selfpracticeproblems.linkedlist.reverse;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        k = k % length;
        ListNode newLast = head;
        for (int i = 1; i < length - k; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }
}
