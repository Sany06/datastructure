package com.example.demo.leetcode150.hashmap;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);
                if (Math.abs(diff) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
