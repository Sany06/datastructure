package selfpracticeproblems.stack.monotonicstack;

import java.util.Stack;

public class AsteriodCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {

            boolean destroyed = false;

            // collision condition
            // collision will only happen if stack.peek()  > 0 and current ast is < 0
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {

                // stack.peek()  is 5
                // ast is -10  (here we are writing -ast as we have to compare the sizes as 5<-10 is making no sense)
                // in this case there will be explosion
                if (stack.peek() < -ast) {
                    stack.pop(); // stack asteroid explodes
                    continue;
                }

                //stack.peek 9
                // ast = 9
                // both explode
                else if (stack.peek() == -ast) {
                    stack.pop();
                }

                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
