package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();

        int i = 0 ,maxLength = 0;


        for (int j = 0 ; j < s.length() ; j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
