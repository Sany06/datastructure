package selfpracticeproblems.arrays.greedy.part2;

import java.util.Arrays;

public class LargestNumber {
    //1. Convert numbers → Strings
    //2. Compare every pair:
    //       "a"+"b" vs "b"+"a"
    //3. Put the one producing the bigger combination first
    //4. Concatenate everything
    //5. Return the result
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));

        if (str[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s: str){
            sb.append(s);
        }

        return sb.toString();
    }
}
