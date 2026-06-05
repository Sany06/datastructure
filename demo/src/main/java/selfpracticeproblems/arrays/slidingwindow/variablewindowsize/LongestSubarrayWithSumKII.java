package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

import java.util.HashMap;
import java.util.Map;
// this approach is applicable for negative values also
public class LongestSubarrayWithSumKII {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, length = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            //Case 1 : if sum == k at i = 1
            if (sum == k) {
                length = i + 1;
            }
            //Case 2 : check if (sum - k) is seen before
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                length = Math.max(length, len);
            }

            //Store first occurrence only
            map.putIfAbsent(sum, i);
        }
        return length;
    }
}
