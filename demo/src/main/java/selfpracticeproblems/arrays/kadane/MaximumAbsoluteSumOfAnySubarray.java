package selfpracticeproblems.arrays.kadane;

public class MaximumAbsoluteSumOfAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = 0, maxSoFar = nums[0];
        int currMin = 0, minSoFar = nums[0];

        for (int num : nums) {

            currMax = Math.max(num, currMax + num);
            maxSoFar = Math.max(maxSoFar, currMax);

            currMin = Math.min(num, currMin + num);
            minSoFar = Math.min(minSoFar, currMin);
        }

        return Math.max(maxSoFar, Math.abs(minSoFar));
    }
}
