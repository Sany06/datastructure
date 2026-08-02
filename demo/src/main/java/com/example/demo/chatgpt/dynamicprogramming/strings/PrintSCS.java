package com.example.demo.chatgpt.dynamicprogramming.strings;

public class PrintSCS {

    public static void main(String[] args) {
        String a = "HELLO";
        String b = "HEEK";

        String scs = printSCS(a, b);
        System.out.println("String A: " + a);
        System.out.println("String B: " + b);
        System.out.println("Shortest Common Supersequence: " + scs);
    }
    public static String printSCS(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Step 1: Build the LCS DP Table
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Trace back from dp[m][n] to construct the SCS
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1)); // Common character included once
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(a.charAt(i - 1)); // Include char from string A
                i--;
            } else {
                sb.append(b.charAt(j - 1)); // Include char from string B
                j--;
            }
        }

        // Step 3: Append remaining characters if any string isn't exhausted
        while (i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }

        // Step 4: Reverse the result string as we built it backwards
        return sb.reverse().toString();
    }
}
