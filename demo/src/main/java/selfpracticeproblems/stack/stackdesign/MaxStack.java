package selfpracticeproblems.stack.stackdesign;

import java.util.Stack;

public class MaxStack {
    public class Node {
        int val;
        int max;
        public Node(int val, int max) {
            this.val=val;
            this.max= max;
        }
    }

    public Stack<Node> stack;
    public MaxStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x,x));
        } else {
            int max = Math.max(x, stack.peek().max);
            stack.push(new Node(x, max));
        }
    }

    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }

    public int peek() {
        if(!stack.isEmpty()) {
            return stack.peek().val;
        } return -1;
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMax() {
        if(!stack.isEmpty())
            return stack.peek().max;
        return -1;
    }
}
