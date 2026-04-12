package selfpracticeproblems.arrays.kadane;

public class MaximumSubarray {
    static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int curr_max = nums[0];
        int max_so_far = nums[0];

        for (int i = 1 ; i< nums.length ; i++) {
            curr_max = Math.max(nums[i] , nums[i] + curr_max);
            max_so_far = Math.max(curr_max,max_so_far);
        }
        return max_so_far;
    }
}
