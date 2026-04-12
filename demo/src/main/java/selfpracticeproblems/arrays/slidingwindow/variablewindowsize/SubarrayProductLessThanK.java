package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, i = 0, product = 1;

        for (int j = 0 ; j < nums.length ; j++) {

            product *= nums[j];

            while (product >= k && i <= j) {
                product /= nums[i];
                i++;
            }

            if (product < k)
                count += (j - i + 1);
        }
        return count;

    }
}
