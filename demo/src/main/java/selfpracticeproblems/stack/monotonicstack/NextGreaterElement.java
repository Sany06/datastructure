package selfpracticeproblems.stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    static void main(String[] args) {
        int[] arr = {1,0,2,1,3};
        System.out.println(Arrays.toString(findNextGreaterElement(arr)));
    }

    private static int[] findNextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack =  new Stack<>();
        for(int i = 0; i< arr.length ; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return result;
    }
}
