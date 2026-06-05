package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;
// sub array sum >= k
public class MinimumSizeSubarraySumK {
    public int minSubArrayLen(int k, int[] arr) {
        int length = Integer.MAX_VALUE, left = 0;
        int sum = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];


            while (sum >= k) {
                length = Math.min(length, right - left + 1);
                sum -= arr[left];
                left++;
            }

        }
        return (length == Integer.MAX_VALUE) ? 0 : length;
    }
}
