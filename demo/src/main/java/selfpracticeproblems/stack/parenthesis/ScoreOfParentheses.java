package selfpracticeproblems.stack.parenthesis;

import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int n = stack.pop();
                int score = Math.max(2 * n, 1);
                stack.push(stack.pop() + score);
            }
        }
        return stack.pop();
    }
}
