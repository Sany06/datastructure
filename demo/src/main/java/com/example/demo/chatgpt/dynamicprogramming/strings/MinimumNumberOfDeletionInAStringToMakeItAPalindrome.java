package com.example.demo.chatgpt.dynamicprogramming.strings;

public class MinimumNumberOfDeletionInAStringToMakeItAPalindrome {
    public int minDeletions(String s) {
        String x = s;
        String y = new StringBuilder(s).reverse().toString();
        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s.length() - dp[m][n];
    }
}
