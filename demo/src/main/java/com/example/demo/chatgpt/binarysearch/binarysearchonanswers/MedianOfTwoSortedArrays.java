package com.example.demo.chatgpt.binarysearch.binarysearchonanswers;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we will  calculate here assuming that length of num1 is smaller than nums2

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int length1 = nums1.length;
        int length2 = nums2.length;

        int low = 0;
        int high = length1; // we are not doing length-1 as we have to calculate partition and not

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (length1 + length2 + 1) / 2 - partition1;

            int l1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int r1 = partition1 == length1 ? Integer.MAX_VALUE : nums1[partition1];

            int l2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int r2 = partition2 == length2 ? Integer.MAX_VALUE : nums2[partition2];

            if (l1 <= r2 && l2 <= r1) {
                if ((length1 + length2) % 2.0 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        return 0.0;
    }
}
