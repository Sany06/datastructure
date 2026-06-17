package com.example.demo.chatgpt.bitmanipulation;

public class FindUniqueNumberAmongTriplets {
    static void main(String[] args) {
        int[] arr = {1,1,1, 2, 3,3,3};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
    int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : arr) {
                if (((num >> i) & 1) == 1) {
                    sum++;
                }
            }

            if (sum % 3 !=0) {
                result = result | (1 << i);
            }
        }
        return result;
    }


}
