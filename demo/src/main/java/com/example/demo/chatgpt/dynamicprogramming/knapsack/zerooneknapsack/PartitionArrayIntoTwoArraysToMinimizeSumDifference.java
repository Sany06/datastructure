package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{3, 9, 7, 3}));
    }

    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) totalSum += num;


        boolean[][] dp = new boolean[n + 1][totalSum + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // fill dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int s1 = 0; s1 < totalSum / 2; s1++) {
            if (dp[n][s1]) {
                int s2 = totalSum - s1;
                min = Math.min(min, Math.abs(s2 - s1));
            }
        }

        return min;
    }
}
