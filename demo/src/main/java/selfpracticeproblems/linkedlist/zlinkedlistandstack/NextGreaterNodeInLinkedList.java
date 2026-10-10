package selfpracticeproblems.linkedlist.zlinkedlistandstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< list.size(); i++) {
            int num = list.get(i);
            while(!stack.isEmpty() && num > list.get(stack.peek())){
                res[stack.pop()] = num;
            }
            stack.push(i);
        }

        return res;
    }
}
