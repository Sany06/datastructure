package com.example.demo.chatgpt.stack;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result=new int[nums.length-k+1];

        for (int i=0;i< nums.length;i++){
            //Step-1
            //Remove the indices that are out of window scope
            if (!deque.isEmpty() && deque.peekFirst()==i-k){
                deque.pollFirst();
            }

            //Step-2
            //remove the indices whose values are less than the present element
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            //Step-3
            deque.offerLast(i);

            //Step-4
            //Start creating the result array once a complete window is created
            if (i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
