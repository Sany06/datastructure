package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {
    public int longestKSubstr(String s, int k) {
        int i = 0, maxLen = -1;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {

            // 1. Expand window
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // 2. Shrink if invalid (distinct > k)
            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }

            // 3. Update answer when exactly k distinct
            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}
