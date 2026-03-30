package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;
//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class PartitionsWithGivenDifference {
    // Code Logic
    //s1 - s2 = diff
    //s1 + s2 = totalSum
    //---------------------
    //2s1     = diff + totalSum
    // s1     = (diff + totalSum)/2
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int a : arr) totalSum += a;

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
