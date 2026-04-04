package com.example.demo.chatgpt.dynamicprogramming.strings;

public class ShortestCommonSuperSequence {

    static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abcdgh", "abedfhr"));
    }
    public static String shortestCommonSupersequence(String x, String y) {
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

        StringBuilder sb = new StringBuilder();

        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(x.charAt(i - 1));
                i--;
            } else {
                sb.append(y.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            sb.append(x.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(y.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }
}
