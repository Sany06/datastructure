package com.example.demo.chatgpt.binarysearch;

public class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid= start+ (end-start)/2;

            if (arr[mid] > arr[mid+1]){  // this means we are in the desc part of the array and we need to search now in the left part of the array
             end = mid;                     // and end can also be the possible ans so we have to consider mid also and not mid=end-1

            } else {                    //this means we are in the asc part of the array
                start=mid+1;
            }
        }
        return start;                   // at the end start and end will be same bcz of the above two conditions, so we can return
                                        // end also
    }
}
