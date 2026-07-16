package com.example.demo.chatgpt.bitmanipulation;

public class FindUniqueNumberAmongTriplets {
    static void main(String[] args) {
        int[] arr = {1,1,1, 2, 3,3,3};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
        int ones = 0, twos = 0;
        for (int num: arr) {
            ones = (ones ^ num ) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }


}
