package selfpracticeproblems.stack.recursivestack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InsertAnElementAtBottomOfStack {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        List<Integer> list = new ArrayList<>();

        while(!st.isEmpty()) {
            list.add(st.pop());
        }

        list.add(x);

        for(int i = list.size() -1 ; i >= 0 ; i--) {
            st.push(list.get(i));
        }

        return st;
    }
}
