package selfpracticeproblems.stack.stackdesign;

import java.util.Stack;

public class MinStack {
    public class Node {
        int val;
        int min;
        public Node(int val, int min) {
            this.val=val;
            this.min= min;
        }
    }

    public Stack<Node> stack;

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val,val));
        } else {
            int min = Math.min(val, stack.peek().min);
            stack.push(new Node(val,min));
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
