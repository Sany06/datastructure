package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;

        for (int num : nums) {
            min = Math.max(min, num);
            max += num;
        }

        int ans = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (ispossible(nums, k, mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    public boolean ispossible(int[] arr, int mid, int k) {
        int count = 0, sum = 0;

        for (int n : arr) {
            if (sum + n <= mid) {
                sum += n;
            } else {
                count++;
                sum = n;
            }
        }
        return count < k;
    }
}
