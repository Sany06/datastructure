package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;

public class CountOfSubsetSum {

    static void main(String[] args) {
        System.out.println(countOfSubsetSum(new int[]{2,3,5,10, 8, 2},10));
    }

    public static int countOfSubsetSum(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];

        dp[0][0] = 1;


        for(int i = 1; i <= arr.length ; i++) {
            for(int j = 0 ; j <= target ; j++) {
                if(arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][target];
    }

}
