package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;

public class CountOfSubsetSum {

    static void main(String[] args) {
        System.out.println(countOfSubsetSum(new int[]{2,3,5,10, 8, 2},10));
    }

    public static int countOfSubsetSum(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];

        // as here sum is j and sum will always be 0
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

}
