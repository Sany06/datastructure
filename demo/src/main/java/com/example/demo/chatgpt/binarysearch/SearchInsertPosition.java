package com.example.demo.chatgpt.binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] arr, int target) {
        if(target > arr[arr.length - 1]) return arr.length;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;  // found
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start; // as start is the first index where element ≥ target
    }
}
