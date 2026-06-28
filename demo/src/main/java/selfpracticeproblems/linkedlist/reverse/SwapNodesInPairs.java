package selfpracticeproblems.linkedlist.reverse;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            //Identify the pair
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Step 1: Rewire first's next
            first.next = second.next;
            // Step 2: Rewire second's next
            second.next = first;
            // Step 3: Connect prev to second
            prev.next = second;
            // Move prev forward to prepare for next swap
            prev = first;
        }

        return dummy.next;

    }
}
