package selfpracticeproblems.bitmanipulation;

public class SingleNumberII {
    static void main(String[] args) {
        int[] arr = {1,1,2,3,3,3,1};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num: nums) {
            ones = (ones ^ num ) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
