package selfpracticeproblems.linkedlist.zlinkedlistandstack;

import java.util.Stack;

public class AddTwoNumbersII {
    public  ListNode add(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while ( !s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int x =  !s1.isEmpty()  ? s1.pop() : 0;
            int y =  !s2.isEmpty() ? s2.pop() : 0;

            int sum = x + y + carry;


            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);

            node.next =  head;

            head = node;

        }

        return head;
    }
}
