package selfpracticeproblems.arrays.kadane;

public class MaximumSubarray {
    static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1 ; i< nums.length ; i++) {
            currMax = Math.max(nums[i] , nums[i] + currMax);
            maxSoFar = Math.max(currMax,maxSoFar);
        }
        return maxSoFar;
    }
}
