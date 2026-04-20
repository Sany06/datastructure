package selfpracticeproblems.linkedlist.reverse;


public class PalindromeLinkList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // Step - 1 : find the middle node in LL
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Step 2: skip middle for odd length
        if (fast != null) {
            slow = slow.next;
        }

        //Step 3. Reverse second half
        ListNode secondHalf = reverseList(slow);

        // 3. Compare both halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
