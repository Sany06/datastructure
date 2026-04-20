package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;
//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class AllocateMinimumPages {
    public int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int min = Integer.MIN_VALUE;
        int max = 0;
        int ans = -1;

        for (int pages : arr) {
            min = Math.max(min, pages);
            max +=  pages;
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
                totalPages = pages;
            }
            else{
                totalPages += pages;
            }
        }
        return student <= k;
    }
}
