package com.example.demo.chatgpt.binarysearch;

public class OrderAgnosticBS {
    static void main(String[] args) {
        //int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int[] arr = {25,22,21,20};
        System.out.println(findIndex(arr, 22));
    }

    public static int findIndex(int[] arr, int target) {
        boolean isAsc = arr[0] < arr[arr.length - 1];

        int start = 0;
        int end = arr.length - 1;


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
