package selfpracticeproblems.stack.recursivestack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public void delete(Stack<Integer> s) {
        List<Integer> list = new ArrayList<>();
        while (!s.isEmpty()) {
            list.add(s.pop());
        }
        list.remove(list.size()/2);
        for (int i = list.size() - 1 ; i >= 0 ; i--) {
            s.push(list.get(i));
        }
    }

    public void deleteMid(Stack<Integer> s) {
        // code here
        if (s.isEmpty()) return;

        int size = s.size();
        helper(s, size, 0);
    }

    public void helper(Stack<Integer> stack, int size, int current) {

        // middle reached
        if (current == size / 2) {
            stack.pop();
            return;
        }

        int top = stack.pop();

        // recursive call
        helper(stack, size, current + 1);

        // push back
        stack.push(top);
    }
}
