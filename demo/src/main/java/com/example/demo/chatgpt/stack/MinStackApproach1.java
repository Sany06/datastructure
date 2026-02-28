package com.example.demo.chatgpt.stack;

import java.util.Objects;
import java.util.Stack;

public class MinStackApproach1 {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStackApproach1() {
        this.stack=new Stack<>();
        this.minstack=new Stack<>();
    }

    public void push(int val) {
      stack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek())
            minstack.push(val);
    }

    public void pop() {
        if (stack.peek()==minstack.peek()){
            stack.pop();
            minstack.pop();
        }
        else stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
    return minstack.peek();
    }
}
