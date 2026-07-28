package com.example.demo.chatgpt.dynamicprogramming.knapsack.zerooneknapsack;

public class EqualSumPartition {
    static void main() {
        System.out.println(isEqualSumPartitionPossible(new int[]{1,2,3}));
        System.out.println(isEqualSumPartitionPossible(new int[]{1,2,2}));
    }

    public static boolean isEqualSumPartitionPossible(int[] arr){
        int totalsum = 0;
        for(int n : arr) {
            totalsum += n;
        }

        if (totalsum % 2 != 0) {
            return false;
        } else {
            return SubsetSum.isSubsetSum(arr,totalsum/2);
        }
    }
}
