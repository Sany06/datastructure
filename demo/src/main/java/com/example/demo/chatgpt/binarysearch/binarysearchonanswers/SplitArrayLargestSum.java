package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;

        for (int num : nums) {
            min = Math.max(min, num);
            max += num;
        }

        int ans = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private boolean canSplit(int[] nums, int k, int mid) {
        int subarraySum = 0;
        int arrayCount = 1;

        for (int num : nums) {
            if (num + subarraySum > mid) {
                arrayCount++;
                subarraySum = num;     // NOTE: here er are not doing subarraySum = num as num + subarraySum > mid so  we cant
                                        // place the current num in the current array and the next array will start with this num
            } else {
                subarraySum += num;
            }
        }
        return arrayCount <= k;  //Here we are doing <= k as if arrayCount is < k then we can split the array into furthur subarray
                                    //But if arrayCount is > k we need to increase the mid value
    }
}
