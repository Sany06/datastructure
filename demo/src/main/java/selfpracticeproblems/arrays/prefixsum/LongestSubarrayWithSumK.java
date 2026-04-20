package selfpracticeproblems.arrays.prefixsum;

import java.util.Hashtable;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public int findLongestSubarrayLength(int[] arr,  int k){
        Map<Integer, Integer> map = new Hashtable<>();

        int sum = 0, maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k){
                maxLength = i + 1;
            }

            if (map.containsKey(sum - k)) {
                int length = i - map.get(sum - k);
                maxLength = Math.max(length,maxLength);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
