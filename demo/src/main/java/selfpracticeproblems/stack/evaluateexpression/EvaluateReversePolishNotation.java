package selfpracticeproblems.stack.evaluateexpression;

import java.util.Stack;

public class EvaluateReversePolishNotation {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack =  new Stack<>();

            for (String token : tokens) {
                switch(token) {
                    case "+" -> stack.push(stack.pop() + stack.pop());
                    case "*" -> stack.push(stack.pop() * stack.pop());
                    case "-" -> {
                        int b = stack.pop(), a = stack.pop();
                        stack.push(a-b);
                    }
                    case "/" -> {
                        int d = stack.pop(), c = stack.pop();
                        stack.push(c/d);
                    }
                    default-> stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
    }
}
