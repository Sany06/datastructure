package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;
//when the totalsum will be negative
public class PartitionArrayIntoTwoArraysToMinimizeSumDifference1 {

    static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{2,-1,0,4,-2,-9}));
    }

    public static int minimumDifference(int[] nums) {
        int n = nums.length;

        int minSum = 0, maxSum = 0;
        for (int num : nums) {
            if (num < 0) minSum += num;
            else maxSum += num;
        }

        int offset = -minSum;
        int range = maxSum - minSum;

        boolean[][] dp = new boolean[n + 1][range + 1];

        dp[0][offset] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= range; j++) {

                if (dp[i - 1][j]) {
                    dp[i][j] = true;

                    int newIndex = j + nums[i - 1];
                    if (newIndex >= 0 && newIndex <= range) {
                        dp[i][newIndex] = true;
                    }
                }
            }
        }

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int minDiff = Integer.MAX_VALUE;

        for (int j = 0; j <= range; j++) {
            if (dp[n][j]) {
                int s1 = j - offset;
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }

        return minDiff;
    }
}
