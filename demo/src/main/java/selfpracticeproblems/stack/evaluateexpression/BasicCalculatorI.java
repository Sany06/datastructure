package selfpracticeproblems.stack.evaluateexpression;

import java.util.Stack;

public class BasicCalculatorI {
        public int calculate(String s) {
            int result = 0;
            int num = 0;
            int sign = 1; // 1 = +, -1 = -
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');    // (c - '0') This converts a digit character into its numeric value
                }
                else if (c == '+') {
                    result += sign * num;
                    num = 0;
                    sign = 1;
                }
                else if (c == '-') {
                    result += sign * num;
                    num = 0;
                    sign = -1;
                }
                else if (c == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                }
                else if (c == ')') {
                    result += sign * num;
                    num = 0;
                    result *= stack.pop(); // sign
                    result += stack.pop(); // previous result
                }
            }

            result += sign * num;
            return result;
    }
}
