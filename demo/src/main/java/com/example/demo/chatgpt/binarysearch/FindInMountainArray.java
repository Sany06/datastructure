package com.example.demo.chatgpt.binarysearch;

import static com.example.demo.chatgpt.binarysearch.FindPeakElement.findPeakElement;

public class FindInMountainArray {
    static void main(String[] args) {
        int[] arr = {0, 1, 4, 7, 9, 11, 5, 3, 0};
        System.out.println(findIndex(arr, 7));
    }

    public static int findIndex(int[] arr, int target) {
        int peakIndex = findPeakElement(arr);
        int index = findIndex(arr, target, 0, peakIndex);
        return index == -1 ? findIndex(arr, target, peakIndex + 1, arr.length - 1) : index;

    }

    public static int findIndex(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else {
                if (isAsc) {
                    if (target > arr[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (target > arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }

        }
        return -1;
    }
}
