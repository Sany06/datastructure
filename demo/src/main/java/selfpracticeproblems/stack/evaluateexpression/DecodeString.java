package selfpracticeproblems.stack.evaluateexpression;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // handle multi-digit numbers
            }
            //Push current number num into stack
            //Push current string
            //Reset current and num
            else if (ch == '[') {
                countStack.push(num);
                num = 0;
                stringStack.push(current);
                current = new StringBuilder();
            }
            //Pop repeat count
            //Pop previous string
            //Repeat current substring k times
            //Append to previous string
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(current);
                }
                current = prev;
            }
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
