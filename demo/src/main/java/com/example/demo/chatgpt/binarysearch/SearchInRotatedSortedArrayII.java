package com.example.demo.chatgpt.binarysearch;

public class SearchInRotatedSortedArrayII {

    public int search(int[] arr, int target) {

        int start = 0, end = arr.length - 1;

        while( start <= end ) {
            int mid = start + (end - start)/2;

            if (arr[mid] == target) return mid;
            // Left half is sorted
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                // Right half is sorted
            } else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
