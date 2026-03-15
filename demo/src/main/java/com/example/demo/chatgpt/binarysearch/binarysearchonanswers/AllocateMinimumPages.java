package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class AllocateMinimumPages {
    public int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int min = Integer.MIN_VALUE;
        int max = 0;
        int ans = -1;

        for (int pages : arr) {
            min = Math.max(min, pages);
            max = max + pages;
        }

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (canAllocate(arr, mid, k)) {
                ans = mid;
                max = mid - 1;
            } else
                min = mid + 1;
        }
        return ans;
    }

    private boolean canAllocate(int[] arr, int mid, int k) {
        int student = 1;
        int totalPages = 0;

        for (int pages : arr) {
            if (totalPages + pages > mid) {
                student++;
                totalPages = 0;
            }
            totalPages += pages;
        }
        return student <= k;
    }
}
