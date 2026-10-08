package com.example.demo.chatgpt.dynamicprogramming.mcm;

public class MatrixChainMultiplication {
    static int matrixMultiplication(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        return solve(arr, 1, n - 1, dp);
    }

    public static int solve(int[] arr, int i , int j , int[][] dp){

        if(i >= j) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int mincost = Integer.MAX_VALUE;

        for(int k = i ; k < j ; k++){
            int cost = solve(arr, i, k, dp) +
                    solve(arr, k + 1, j, dp) +
                    arr[i - 1] * arr[k] * arr[j];

            mincost = Math.min(mincost,cost);
        }

        return dp[i][j] = mincost;
    }
}
