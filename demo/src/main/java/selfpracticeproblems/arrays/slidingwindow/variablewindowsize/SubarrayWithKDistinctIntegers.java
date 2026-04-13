package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDistinctIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMostK(nums,k) - atMostK(nums, k-1);
    }
    public static int atMostK(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0 , count = 0;

        for (int j = 0 ; j < nums.length ; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() > k){
                map.put(nums[i], map.get(nums[i]) - 1 );

                if (map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }

            count = count + (j - i + 1);
        }
        return count;

    }
}
