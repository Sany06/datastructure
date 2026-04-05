package com.example.demo.leetcode150.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int maxLength = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int current = n;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }

        }
        return maxLength;
    }
}
