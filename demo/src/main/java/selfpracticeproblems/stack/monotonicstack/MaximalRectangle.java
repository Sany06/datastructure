package selfpracticeproblems.stack.monotonicstack;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxlength = 0;

        int row = matrix.length;
        int col =  matrix[0].length;

        int[] arr = new int[col];

        for (int i = 0; i < row ;  i++) {
            for (int j  = 0; j < col ; j++) {
                if (matrix[i][j] == '1') {
                    arr[j] += 1;
                } else {
                    arr[j] = 0;
                }
            }
            maxlength = Math.max(maxlength, findMax(arr) );
        }
        return maxlength;
    }

    public int findMax(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxLength = 0;

        for(int i = 0; i <= n ; i++) {
            int currHeight = ( i == n ) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()] ) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxLength = Math.max(maxLength, height * width);
            }
            stack.push(i);
        }
        return maxLength;
    }
}
