package com.example.demo.chatgpt.dynamicprogramming;

public class MaximumSubarray {

    static void main() {
        int[] arr={-2,-1,4};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums) {

        int curr_max = nums[0];
        int max_so_far = nums[0];

        for (int i = 1; i < nums.length; i++) {

            curr_max = Math.max(nums[i], nums[i] + curr_max);

            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }
}
