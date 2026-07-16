package com.example.demo.chatgpt.bitmanipulation;

public class ResetIthBit {
    static void main(String[] args) {
        int n = 10; //1010
        int i = 3;
        System.out.println(reSetIthBit(n,i));
    }
    //Here we are creating a mask by doing ~(1 << i) & n
    private static int reSetIthBit(int n , int i) {
        return ~( 1 << i) & n;
    }
}
