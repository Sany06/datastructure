package com.example.demo.chatgpt.bitmanipulation;

public class FindNoOfSetBit {
    static void main() {
        System.out.println(findNoOfSetBit(10));
    }

    private static int findNoOfSetBit(int n){
        int count = 0;

        while (n > 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
