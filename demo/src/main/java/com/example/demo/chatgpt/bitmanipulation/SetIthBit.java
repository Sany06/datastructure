package com.example.demo.chatgpt.bitmanipulation;

public class SetIthBit {
    static void main(String[] args) {
        int n = 10;
        int i = 2;
        System.out.println(setIthBit(n,i));
    }


    private static int setIthBit(int n, int i) {
    return ( 1 << i) | n;
    }
}
