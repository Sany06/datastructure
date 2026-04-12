package com.example.demo.leetcode150.array.slidingwindow;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int  count = 0 ,maxCount = 0;

        for (int num : nums ) {
            if (num == 1) {
                count++;
                maxCount = Math.max(count,maxCount);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
