package com.example.demo.chatgpt.bitmanipulation;

public class NumberOfDigits {
    static void main(String[] args) {
        int n = 1234;
        int b = 10;
        int digit = (int) (Math.log(n)/ Math.log(b)) + 1;
        System.out.println(digit);
    }
}
