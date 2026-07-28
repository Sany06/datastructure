package selfpracticeproblems.stack.greedy;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] lastseenIndex = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            lastseenIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if (seen[ch - 'a'])
                continue;

            while ( !stack.isEmpty() &&
                        ch < stack.peek() &&
                        lastseenIndex[stack.peek() - 'a'] > i)   //Can we safely remove the top? So we only pop when another copy exists later.
            {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            seen[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();

    }
}
