package selfpracticeproblems.bitmanipulation;

import java.util.Arrays;

public class SingleNumberIII {
    static void main(String[] args) {
    int[] arr = {1,1,2,3,3,4};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int n : nums){
            xor ^= n;
        }

        int bit = xor & -xor;   // for finding the rightmost set bit

        int a = 0, b = 0;

        for (int n : nums) {
            if ((bit & n) == 0) {
                a ^= n;
            } else{
                b^=n;
            }
        }
        return a < b ? new int[]{a, b} : new int[]{b, a};
    }
}
