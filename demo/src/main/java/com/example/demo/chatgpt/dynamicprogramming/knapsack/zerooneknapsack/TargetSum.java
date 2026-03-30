package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;

public class TargetSum {
    //This problem is same as Partitions with given difference

    public int findTargetSumWays(int[] arr, int diff) {
        int totalSum = 0;
        for (int a : arr) totalSum += a;

        if (Math.abs(diff) > totalSum) return 0;

        if ((totalSum + diff) % 2 != 0) return 0;


        int target = (diff + totalSum)/2;

        return isSubsetSum(arr,target);


    }

    public static int isSubsetSum(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];

        // as here sum is j and sum will always be 0

        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {

                if (nums[i - 1] == 0) {
                    // special case: zero doubles count
                    dp[i][j] = dp[i - 1][j] * 2;
                }

                else if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
