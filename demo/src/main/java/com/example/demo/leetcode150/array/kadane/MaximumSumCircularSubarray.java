package com.example.demo.leetcode150.array.kadane;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0, maxSoFar = nums[0];
        int currMin = 0, minSoFar = nums[0];

        for(int num : nums) {

            //max for kadane
            currMax = Math.max(num, currMax + num);
            maxSoFar = Math.max(maxSoFar,currMax);

            //
            currMin = Math.min(num, num + currMin);
            minSoFar = Math.min(minSoFar,currMin);

            totalSum += num;

        }
        //if all elements are negative
        if (maxSoFar < 0 ) return maxSoFar;

        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}
