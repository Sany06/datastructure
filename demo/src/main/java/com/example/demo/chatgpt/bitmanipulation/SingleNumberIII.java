package com.example.demo.chatgpt.bitmanipulation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int a = 0;

        for (int n : nums) {
            a ^= n;
        }

        int bit = a & -a;

        int firstNum = 0, secondNum = 0;

        for (int n : nums) {
            if ((bit & n) == 0) {
                firstNum = firstNum ^ n;
            } else {
                secondNum = secondNum ^ n;
            }
        }
        return new int[]{firstNum, secondNum};
    }
}
