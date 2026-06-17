package com.example.demo.chatgpt.bitmanipulation;

public class ResetIthBit {
    static void main(String[] args) {
        int n = 10; //1010
        int i = 3;
        System.out.println(setIthBit(n,i));
    }

    private static int setIthBit(int n , int i) {
        return ~( 1 << i) & n;
    }
}
