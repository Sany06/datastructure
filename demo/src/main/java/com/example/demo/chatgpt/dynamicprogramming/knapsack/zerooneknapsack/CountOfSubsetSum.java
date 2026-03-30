package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;

public class CountOfSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return isSubsetSum(nums, sum / 2);


    }

    boolean isSubsetSum(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        // as here sum is j and sum will always be 0
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }


        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];

    }
}
