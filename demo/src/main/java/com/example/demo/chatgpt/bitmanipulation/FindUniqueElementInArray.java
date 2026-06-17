package com.example.demo.chatgpt.bitmanipulation;

public class FindUniqueElementInArray {
    static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4};
        System.out.println(findunique(arr));
    }

    //Formula is a^a = 0 & a^0 = 1
    // Since XOR follows associative property so 1^1^2^3^3^4^4 = 2

    private static int findunique(int[] arr) {
        int unique = 0;

        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
