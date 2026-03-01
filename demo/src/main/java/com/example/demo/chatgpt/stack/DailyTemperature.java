package com.example.demo.chatgpt.stack;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperature {

    static void main() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] newarr=new int[length];

        for (int i=length-1;i>=0;i--){

            while (!stack.isEmpty() && temperatures[i]>= temperatures[stack.peek()]){
            stack.pop();
            }

            if (!stack.isEmpty()){
                newarr[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return newarr;
    }
}
