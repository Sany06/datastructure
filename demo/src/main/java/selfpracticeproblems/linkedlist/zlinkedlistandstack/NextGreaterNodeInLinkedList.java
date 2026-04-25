package selfpracticeproblems.linkedlist.zlinkedlistandstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(stack.peek()) <= list.get(i)) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : list.get(stack.peek());

            stack.push(i);
        }

        return res;
    }
}
