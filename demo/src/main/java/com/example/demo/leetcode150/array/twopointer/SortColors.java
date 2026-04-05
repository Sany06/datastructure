package com.example.demo.leetcode150.array.twopointer;

public class SortColors {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0 , end = nums.length -1;

        while (mid <= end){
            switch(nums[mid]) {
                case 2 : swap(nums,mid,end);
                    end--;
                    break;
                case 1 : mid++;
                    break;
                case 0 : swap(nums, start, mid);
                    start++;
                    mid++;
                    break;
                default : break;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
