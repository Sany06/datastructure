package com.example.demo.chatgpt.recursion;

public class Factorial {
    static void main(String[] args) {
        System.out.println(factorial(3));
    }
    static int factorial(int n) {
        // code here
        if (n==1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
