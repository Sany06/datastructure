package com.example.demo.chatgpt.binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirstIndex(nums, target);
        int lastIndex = findLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int findLastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {                ans=mid;
                start=mid+1;
            } else if (nums[mid]>target){
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return ans;
    }

    private int findFirstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans=mid;
                end=mid-1;
            } else if (nums[mid]>target){
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return ans;
    }
}
