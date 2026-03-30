package com.example.demo.chatgpt.dynamicprogramming.knapsack.unbounded;

public class CoinChangeII {
    public int change(int target, int[] nums) {
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
                    dp[i][j] = dp[i][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
