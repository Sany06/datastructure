package com.example.demo.chatgpt.recursion.backtracking;

public class NextPermutation {
    static void main(String[] args) {
        int[] nums = {1, 2, 3};

    }

    public void nextPermutation(int[] nums) {
        //Step-1  find the first smallest number before the last index
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //Step-2
        //Find the first greatest number after i and swap it
        if (i >= 0) {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        //Step-3
        //reverse the part after i
        reverse(nums,i+1,nums.length-1);

    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }




}
