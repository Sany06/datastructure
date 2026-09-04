package com.example.demo.chatgpt.bitmanipulation;

public class FindUniqueNumberAmongTriplets {
    static void main(String[] args) {
        int[] arr = {1,1,1, 2, 3,3,3};
        System.out.println(findUnique(arr));
    }
    //ONES = seen once
    //TWOS = seen twice
    //seen three times = remove
    private static int findUnique(int[] arr) {
        int ones = 0, twos = 0;
        for (int num: arr) {
            //"Put the bits from num into the ONES bucket, but don't keep anything that's already in the TWOS bucket."
            ones = (ones ^ num ) & ~twos;
            //"Put the bits from num into the TWOS bucket, but don't keep anything that's already in the ONES bucket."
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }


}
