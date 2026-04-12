package com.example.demo.leetcode150.array.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int k, int[] arr) {
        int res = Integer.MAX_VALUE, left = 0;
        int sum = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];


            while (sum >= k) {
                res = Math.min(res, right - left + 1);
                sum -= arr[left];
                left++;
            }

        }
        return res;
    }
}
