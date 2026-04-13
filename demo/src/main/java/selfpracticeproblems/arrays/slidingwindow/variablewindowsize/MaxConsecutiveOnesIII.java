package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int i = 0 , resCount = 0, zero = 0;

        for (int j = 0 ; j < nums.length ; j++) {
            if(nums[j] == 0) zero++;

            while(zero > k){
                if(nums[i] == 0){
                    zero--;
                }
                i++;
            }

            resCount = Math.max(resCount, j - i + 1);
        }

        return resCount;

    }
}
