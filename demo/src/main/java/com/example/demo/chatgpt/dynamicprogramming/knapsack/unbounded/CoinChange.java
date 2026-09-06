package com.example.demo.chatgpt.dynamicprogramming.knapsack.unbounded;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        int MAX = amount + 1;

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = MAX;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    //The main change is here
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}
