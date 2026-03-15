package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int minCapacity = 0;
        int maxCapacity = 0;

        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }

        while (minCapacity < maxCapacity) {
            int mid = minCapacity + (maxCapacity - minCapacity) / 2;

            int sum = 0, days = 1;
            for (int weight : weights) {
                if (sum + weight > mid) {
                    days++;
                    sum = 0;
                }
                sum += weight;
            }

            if (days > D) {
                minCapacity = mid + 1;
            } else {
                maxCapacity = mid;
            }
        }
        return minCapacity;


    }
}
