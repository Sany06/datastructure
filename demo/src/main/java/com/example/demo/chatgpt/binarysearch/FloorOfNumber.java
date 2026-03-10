package com.example.demo.chatgpt.binarysearch;

public class FloorOfNumber {
    public int floorOfNumber(int[] arr, int target) {
        if(target > arr[arr.length - 1]) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid]==target){
                return arr[mid];
            }
        }
        return arr[end];
    }
}
