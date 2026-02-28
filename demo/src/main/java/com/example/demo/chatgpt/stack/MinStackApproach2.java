package com.example.demo.chatgpt.stack;

import java.util.Objects;
import java.util.Stack;

public class MinStackApproach2 {
    public class Node{
        int val;
        int min;
        public Node(int val,int min){
            this.val=val;
            this.min=min;
        }
    }
    private final Stack<Node> nodeStack=new Stack<>();

    public void push(int val) {
        if (nodeStack.isEmpty()){
            nodeStack.push(new Node(val,val));
        }  else {
            int min=nodeStack.peek().min;
            nodeStack.push(new Node(val, Math.min(val, min)));
        }
    }

    public void pop() {
        nodeStack.pop();
    }

    public int top() {
        return nodeStack.peek().val;
    }

    public int getMin() {
    return nodeStack.peek().min;
    }
}
