package com.example.demo.leetcode150.array.twopointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length -1;

        while (left < right) {
            int length = Math.min(height[left],height[right]);
            int breadth = right - left;
            int area = length * breadth;
            maxArea = Math.max(maxArea,area);

            if(height[left] > height[right]){
                right--;
            } else left++;

        }
        return maxArea;
    }
}
