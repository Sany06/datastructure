package com.example.demo.chatgpt.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    static void main() {
        int[]  arr={2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 26)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++){
            map.put(nums[i], i);
        }

        for (int i=0;i< nums.length;i++){
            int comp=target-nums[i];
            if (map.containsKey(comp) && map.get(comp)!=i){
                return new int[]{map.get(comp),i};
            }
        }
        return new int[]{};
    }
}
