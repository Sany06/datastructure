package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;
//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class PerfectSumProblem {
    static void main(String[] args) {
        int[] arr={5, 2, 3, 10, 6, 8};
        System.out.println(isSubsetSum(arr,10));
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

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];

    }
}
