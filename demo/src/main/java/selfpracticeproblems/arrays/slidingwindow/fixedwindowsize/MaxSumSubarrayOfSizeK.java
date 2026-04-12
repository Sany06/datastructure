package selfpracticeproblems.arrays.slidingwindow.fixedwindowsize;

public class MaxSumSubarrayOfSizeK {
    public int maxSubarraySum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;

        int n = arr.length;

        while (j < n) {
            sum += arr[j];

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                sum -= arr[i];

                i++;
                j++;
            }
        }
        return maxSum;

    }
}
