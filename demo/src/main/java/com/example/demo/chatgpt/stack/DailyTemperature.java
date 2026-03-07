package com.example.demo.chatgpt.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperature {
//73,74,75,71,69
    static void main() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 25, 50, 60})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] newarr = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            //Step-1
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            //Step-2
            if (!stack.isEmpty()) {
                newarr[i] = stack.peek() - i;
            }
            //Step-3
            stack.push(i);
        }
        return newarr;
    }
}
