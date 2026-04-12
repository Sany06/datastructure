package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;
// GFG
public class LongestSubarrayWithSumK {
    //this code works only for positive inputs
    public int longestSubarray(int[] arr, int k) {
        int i = 0, length = 0 ,sum = 0;

        for (int j = 0 ; j< arr.length ; j++) {
             sum += arr[j];

             while (sum > k) {
                 sum -= arr[i];
                 i++;
             }

             if (sum == k) {
                 length = Math.max(length, j  - i + 1);
             }
        }
        return length;
    }
}
