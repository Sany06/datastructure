package com.example.demo.chatgpt.binarysearch;

public class SearchInRotatedSortedArray {

    public int search(int[] arr, int target) {
        int pivot = findPivotIndex(arr);

        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        //{4,5,6,7,,0,1,2} here we are searching 6 and our pivot is 7 so  it is evident that 6 will lie btwn arr[0] to arr[pivot]
        if (target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot-1);
        } else {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
    }


    public static int findPivotIndex(int[] arr) {
        //For finding peak we have 4 cases
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //Case-1 In any rotated sorted array there will be only one case when arr[mid]> arr[mid+1]. When this condition is met
            //then we have found the pivot
            //Since we are checking arr[mid+1] so there is a chance of array index out of bound, so we have to check if mid < end
            //Example-{16,19,1,2,3}
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
                //Case-2 In any rotated sorted array there will be only one case when arr[mid]< arr[mid-1]. When this condition is met
                //then we have found the pivot
                //Since we are checking arr[mid-1] so there is a chance of array index out of bound, so we have to check if mid > start
                //Example-{16,19,1,2,3}
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
                //Case-3  If the above two conditions are not met then we have to update the mid in order to traverse the array
                //So the first case can bre the arr[start] > arr[mid]. In this case we have to make end=mid-1;
                //Example-{4,5,6,3,2,1,0}      arr[mid]=3, so   arr[start]> arr[mid]  In this scenario the peek element lies to the left of the mid
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
                //Case-4  If the above three conditions are not met then we have to update the mid in order to traverse the array
                //So the second case can br the arr[start] < arr[mid]. In this case we have to make start=mid+1;
                //Example-{3,4,5,6,2}      arr[mid]=5, so   arr[start]< arr[mid] In this scenario the peek element lies to the right of the mid
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
