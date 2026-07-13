package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int minCapacity = 0;
        int maxCapacity = 0;
        int ans = -1;

        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }

        while (minCapacity < maxCapacity) {
            int mid = minCapacity + (maxCapacity - minCapacity) / 2;

            if (isPossible(mid, weights, D)) {
                ans = mid;
                maxCapacity = mid - 1;
            } else {
                minCapacity = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int mid, int[] weights, int D) {
        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight <= mid) {
                currentLoad += weight;
            } else {
                requiredDays++;
                currentLoad = weight;
            }
        }

        return requiredDays <= D;
    }
}
