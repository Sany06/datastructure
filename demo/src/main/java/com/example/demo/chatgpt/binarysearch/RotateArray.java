package com.example.demo.chatgpt.binarysearch;

public class RotateArray {
    //There are 3 steps to rotate an array by k times
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        // We have to reduce no of rotation as k can be greater than arraylength,
        //so we are counting the effective rotation as rotating the array k times
        //means we will get the same array
        k = k % n;
        //Step 1: Reverse the full array
        rotateArr(nums,0,nums.length-1);
        //Step 2: Reverse from 0th index to k-1 index
        rotateArr(nums,0,k-1);
        //Step 3: Reverse frpm kth index to arraylength-1 index
        rotateArr(nums,k,nums.length-1);
    }

    public void rotateArr(int[] arr,int startIndex,int endIndex){
        while(startIndex<=endIndex){
            int temp=arr[startIndex];
            arr[startIndex]=arr[endIndex];
            arr[endIndex]=temp;
            startIndex++;
            endIndex--;
        }
    }
}
