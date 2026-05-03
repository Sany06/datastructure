package selfpracticeproblems.linkedlist.reverse;


public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // 1. Find kth node → end of current group
            ListNode kth = getKth(groupPrev,k);
            if (kth ==null) break;

            // 2. Define pointers
            ListNode currentGroupStart = groupPrev.next;
            ListNode nextGroupStart = kth.next;

            // 3. Reverse current group
            ListNode prev = nextGroupStart;
            ListNode curr = currentGroupStart;

            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 4. Reconnect
            groupPrev.next = kth;                  // new head
            groupPrev = currentGroupStart;         // move to next group
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
