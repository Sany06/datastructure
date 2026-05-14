package selfpracticeproblems.stack.monotonicstack;

import java.util.Stack;

public class OnlineStockSpan {

    Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        //This loop removes all smaller/equal prices from the stack.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span +=  stack.peek()[1];
            stack.pop();
        }


        stack.push(new int[]{price, span});
        return span;
    }
}
