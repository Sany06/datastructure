package selfpracticeproblems.stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    private static int[] findNextGreaterElement(int[] arr) {
       int n = arr.length;
       int[] result = new int[arr.length];
       Stack<Integer> stack = new Stack<>();
       Arrays.fill(result,-1);

        for (int i = 0; i < 2*n ; i++) {
            int num = arr[i % n];
            while (!stack.isEmpty() && arr[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
