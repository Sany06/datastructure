package com.example.demo.chatgpt.dynamicprogramming.mcm;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrue {
    Map<String, Integer> map = new HashMap<>();

    public int countways(String s) {
        map.clear();
        return solve(s, 0, s.length() - 1, true);
    }

    private int solve(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        String key = i + " " + j + " " + isTrue;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ways = 0;

        for (int k = i + 1; k < j; k += 2) {
            int lt = solve(s, i, k - 1, true);
            int lf = solve(s, i, k - 1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);

            char operator = s.charAt(k);

            if (operator == '&') {
                if (isTrue) {
                    ways += lt * rt;
                } else {
                    ways += lt * rf + lf * rt + lf * rf;
                }

            } else if (operator == '|') {
                if (isTrue) {
                    ways += lt * rt + lt * rf + lf * rt;
                } else {
                    ways += lf * rf;
                }

            } else { // ^
                if (isTrue) {
                    ways += lt * rf + lf * rt;
                } else {
                    ways += lt * rt + lf * rf;
                }
            }
        }
        map.put(key,ways);
        return ways;
    }


}
