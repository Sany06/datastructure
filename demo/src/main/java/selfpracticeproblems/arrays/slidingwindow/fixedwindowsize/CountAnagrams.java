package selfpracticeproblems.arrays.slidingwindow.fixedwindowsize;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {
    public int countAnagrams(String txt, String pat) {
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : pat.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size();
        int k = pat.length();
        int i = 0, j = 0;
        int ans = 0;

        while (j < txt.length()) {
            // Calculation for j
            char charJ = txt.charAt(j);
            if (map.containsKey(charJ)) {
                map.put(charJ, map.get(charJ) - 1);
                if (map.get(charJ) == 0) count--;
            }

            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
            // Answer calculation
                if (count == 0) ans++;

            // Slide the window
                char charI = txt.charAt(i);
                if (map.containsKey(charI)) {
                    map.put(charI, map.get(charI) + 1);
                    if (map.get(charI) == 1) count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
