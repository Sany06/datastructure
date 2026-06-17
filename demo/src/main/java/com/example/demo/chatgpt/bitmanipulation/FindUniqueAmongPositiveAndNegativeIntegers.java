package com.example.demo.chatgpt.bitmanipulation;

public class FindUniqueAmongPositiveAndNegativeIntegers {
    static void main(String[] args) {
        int[] arr = {1, -1, 2, 3, -3, 4, -4};
        System.out.println(findunique(arr));
    }

    private static int findunique(int[] arr) {
        int unique = 0;

        for (int n : arr) {
            unique += n;
        }
        return unique;
    }
}
