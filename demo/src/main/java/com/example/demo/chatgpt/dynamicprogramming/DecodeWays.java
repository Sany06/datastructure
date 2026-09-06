package com.example.demo.chatgpt.dynamicprogramming;

public class DecodeWays {
    // waystodecode[i] = waystodecode[i - 1] + waystodecode[i - 2]

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int onesplace = s.charAt(i - 1) - '0';

            if (onesplace >= 0) {
                dp[i] = dp[i] + dp[i - 1];
            }

            int tensplace = Integer.valueOf(s.substring(i - 2, i));

            if (tensplace >= 10 && tensplace <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[n];
    }
}
