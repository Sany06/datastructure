package selfpracticeproblems.stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    static void main(String[] args) {
        int[] arr = {3,2,1};
        System.out.println(Arrays.toString(findNextSmallerElement(arr)));
    }

    private static int[] findNextSmallerElement(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack =  new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }
}
