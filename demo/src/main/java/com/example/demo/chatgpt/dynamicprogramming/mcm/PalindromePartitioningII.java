package com.example.demo.chatgpt.dynamicprogramming.mcm;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        return solve(s, 0, n - 1, dp);
    }

    public boolean ispalindrome(String s , int i , int j) {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int solve(String s, int i , int j, int[][] dp) {

        if(i >= j || ispalindrome(s,i,j)) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int mincount = Integer.MAX_VALUE;

        for(int k = i; k < j ; k++) {
            int count = 1 + solve(s, i, k, dp) + solve(s, k + 1, j, dp);
            mincount = Math.min(count,mincount);
        }

        return dp[i][j] = mincount;

    }
}
