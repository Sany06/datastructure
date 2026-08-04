package com.example.demo.chatgpt.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lis(arr));
    }

    public static int lis(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxlength = 1;

        for(int i = 1; i <nums.length; i++) {
            for(int j = 0; j < i ; j++) {
                if(nums[i] >  nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxlength = Math.max(maxlength, dp[i]);
        }

        return maxlength;
    }
}
