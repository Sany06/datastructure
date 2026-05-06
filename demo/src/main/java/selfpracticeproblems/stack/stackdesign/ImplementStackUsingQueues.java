package selfpracticeproblems.stack.stackdesign;

import java.util.Stack;

public class ImplementStackUsingQueues {
    public Stack<Integer> fstack;
    public Stack<Integer> sstack;

    public ImplementStackUsingQueues() {
        fstack = new Stack<>();
        sstack = new Stack<>();

    }

    public void push(int x) {
        if (fstack.isEmpty()) {
            fstack.push(x);
        } else {
            while (!fstack.isEmpty()) {
                sstack.push(fstack.pop());
            }

            sstack.push(x);

            while(!sstack.isEmpty()) {
                fstack.push(sstack.pop());
            }
        }

    }

    public int pop() {
        return fstack.pop();

    }

    public int peek() {
        return fstack.peek();
    }

    public boolean empty() {
        return fstack.isEmpty();
    }
}
