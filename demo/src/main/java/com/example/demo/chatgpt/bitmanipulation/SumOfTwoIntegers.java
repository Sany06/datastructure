package com.example.demo.chatgpt.bitmanipulation;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(5, 7));     // 12
        System.out.println(getSum(10, 15));   // 25
        System.out.println(getSum(-5, 3));    // -2
    }

    private static int getSum(int a, int b) {

        while (b != 0){
            int carry = ( a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
