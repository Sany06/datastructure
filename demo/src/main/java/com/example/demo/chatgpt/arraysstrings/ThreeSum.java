package com.example.demo.chatgpt.arraysstrings;

import java.util.*;

public class ThreeSum {
    static void main() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // 1) Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optional optimization: if nums[i] > 0, no possible triplets (sorted)
            if (nums[i] > 0) break;

            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    // 2) Skip duplicates for l
                    while (l < r && nums[l] == nums[l - 1]) l++;

                    // 3) Skip duplicates for r
                    while (l < r && nums[r] == nums[r + 1]) r--;

                } else if (sum < 0) {
                    l++; // need a bigger sum
                } else {
                    r--; // need a smaller sum
                }
            }
        }
        return res;
    }
}
