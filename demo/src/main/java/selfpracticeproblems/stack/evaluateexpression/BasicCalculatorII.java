package selfpracticeproblems.stack.evaluateexpression;

import java.util.Stack;

public class BasicCalculatorII {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //Step-1 construct the num
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');   // (c - '0') This converts a digit character into its numeric value
            }

            //Step- 2 process if we are getting sign
            // We delay + and -, but resolve * and / immediately.
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                //Remember to reset the sign and num
                sign = ch;
                num = 0;
            }
        }


        for (int val : stack) {
            result += val;
        }

        return result;
    }
}
