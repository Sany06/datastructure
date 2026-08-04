package com.example.demo.chatgpt.dynamicprogramming.knapsack.unbounded;

public class RodCuttingProblem {
    static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(solution(prices,8));
    }

    private static int solution(int[] prices, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                dp[i][j] = dp[i - 1][j];

                if (i <= j) {
                    dp[i][j] = Math.max(dp[i][j], prices[i - 1] + dp[i][j - i]);
                }
            }
        }

        return dp[n][n];
    }
}
