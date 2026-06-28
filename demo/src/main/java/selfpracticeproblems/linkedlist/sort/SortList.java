package selfpracticeproblems.linkedlist.sort;

public class SortList {

    //Approach
    //Find mid
    //sort halves
    //merge sorted halves
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find mid
        ListNode mid = getMid(head);

        ListNode rightHead = mid.next;
        mid.next = null;

        // Sort left and right
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Merge
        return merge(left, right);
    }

    public ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (l1 != null) {
            tail.next = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }
}
