package selfpracticeproblems.arrays.kadane;

public class MaximumProductSubarray {

    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currMax = nums[0];
        int currMin = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            // If negative, swap
            if (val < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(val, val * currMax);
            currMin = Math.min(val, val * currMin);

            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
    public int maxProduct2(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * currMin));

            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }


}
